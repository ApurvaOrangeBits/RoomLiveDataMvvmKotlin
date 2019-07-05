package com.example.roomlivedatamvvmkotlin.activites

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Gravity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.LinearLayout
import androidx.annotation.NonNull
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomlivedatamvvmkotlin.R
import com.example.roomlivedatamvvmkotlin.adapters.AdpListData
import com.example.roomlivedatamvvmkotlin.databinding.ActDashboardBinding
import com.example.roomlivedatamvvmkotlin.databinding.AdpListBinding
import com.example.roomlivedatamvvmkotlin.model.ModListData
import com.example.roomlivedatamvvmkotlin.viewmodel.VmActDashboard
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import kotlinx.android.synthetic.main.adp_list.*
import kotlinx.android.synthetic.main.app_bar_act_dashboard.view.*
import kotlinx.android.synthetic.main.content_act_dashboard.*
import kotlinx.android.synthetic.main.content_act_dashboard.view.*

class ActDashboard : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding :ActDashboardBinding
    lateinit var viewmodel  :VmActDashboard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@ActDashboard,R.layout.act_dashboard)
        viewmodel=ViewModelProviders.of(this@ActDashboard).get(VmActDashboard::class.java)
        binding.vmactdashboard=viewmodel

        viewmodel.setList().observe(this@ActDashboard, Observer {
            binding.include1.app_bar.rv_list.adapter=AdpListData(this@ActDashboard,it)
//            Log.d("TAG","it : "+it.get(0).modListData.name)
        })

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_list.layoutManager=linearLayoutManager

        // snapping the scroll items
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(binding.include1.app_bar.rv_list)

        // set a timer for default item
        val handler = Handler()
        handler.postDelayed({
            // Do something after 1ms = 100ms
            val viewHolderDefault =rv_list.findViewHolderForAdapterPosition(0)

            val eventparentDefault = viewHolderDefault!!.itemView.findViewById<LinearLayout>(R.id.eventsplace)
            eventparentDefault.animate().scaleY(1f).scaleX(1f).setDuration(350)
                .setInterpolator(AccelerateInterpolator()).start()

            val eventcategoryDefault = viewHolderDefault!!.itemView.findViewById<LinearLayout>(R.id.eventsplace)
            eventcategoryDefault.animate().alpha(1f).setDuration(300).start()
        }, 100)

        // add animate scroll
        rv_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(@NonNull recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    var view=snapHelper!!.findSnapView(linearLayoutManager)
                    Log.d("TAG","selected  view : "+view)
                    val pos = linearLayoutManager.getPosition(view!!.findViewById(R.id.eventsplace))
                    Log.d("TAG","selected  position : "+pos)

                    val viewHolder=recyclerView.findViewHolderForAdapterPosition(pos)

                    val eventparent = viewHolder!!.itemView.findViewById<LinearLayout>(R.id.eventsplace)
                    eventparent.animate().scaleY(1f).scaleX(1f).setDuration(350)
                        .setInterpolator(AccelerateInterpolator()).start()


                } else {

                    var view=snapHelper!!.findSnapView(linearLayoutManager)
                    val pos = linearLayoutManager.getPosition(view!!.findViewById(R.id.eventsplace))
                    Log.d("TAG","unselected  position : "+pos)

                    val viewHolder=recyclerView.findViewHolderForAdapterPosition(pos)

                    val eventparent = viewHolder!!.itemView.findViewById<LinearLayout>(R.id.eventsplace)
                    eventparent.animate().scaleY(0.7f).scaleX(0.7f).setInterpolator(AccelerateInterpolator())
                        .setDuration(350).start()
                }
            }

            override fun onScrolled(@NonNull recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
//        val toggle = ActionBarDrawerToggle(
//            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
//        )
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)



    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.act_dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
