package com.example.roomlivedatamvvmkotlin.contentprovider

import android.content.ContentProvider
import android.content.ContentResolver
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.example.roomlivedatamvvmkotlin.Database.AppDatabase

class CustomContentProvider : ContentProvider(){


         val MATCHER = UriMatcher(UriMatcher.NO_MATCH)

        val AUTHORITY = "roomlivedatamvvmkotlin.contentprovider.success"

        val PATH_TODO_LIST = "users"

        val CONTENT_URI_1 = Uri.parse("content://$AUTHORITY/$PATH_TODO_LIST")

        val TODOS_LIST = 1

        init {
            MATCHER.addURI(AUTHORITY, PATH_TODO_LIST, TODOS_LIST)

        }



    val MIME_TYPE_1 = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + "roomlivedatamvvmkotlin.contentprovider.success.users"

    private var appDatabase: AppDatabase? = null


    override fun query(p0: Uri, p1: Array<String>?, p2: String?, p3: Array<String>?, p4: String?): Cursor? {

        Log.d("TAG","inside query : "+p0)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(): Boolean {
        Log.d("TAG","inside onCreate")
        appDatabase= AppDatabase.getInstance(context)
        return true
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<String>?): Int {
        Log.d("TAG","inside update")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<String>?): Int {
        Log.d("TAG","inside delete")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        Log.d("TAG","inside insert")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(uri: Uri): String? {
        when (MATCHER.match(uri)) {

            TODOS_LIST -> return MIME_TYPE_1

        }
        Log.d("TAG","inside getType matcher")
        return null
    }

}