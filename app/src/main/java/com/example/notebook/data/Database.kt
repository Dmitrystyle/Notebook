package com.example.notebook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.notebook.data.dao.DAO
import com.example.notebook.model.Model
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.SynchronizedObject


@Database(entities = [Model::class], version = 1)

abstract class NoteDatabase: RoomDatabase() {

    abstract fun getDAO():DAO


    companion object{
        private var database: NoteDatabase ?=null

        @Synchronized
         fun getInstance(context:Context):NoteDatabase {
           return if (database == null) {
                database = databaseBuilder(context, NoteDatabase::class.java, "db").build()
                database as NoteDatabase
           }

           else
                {
                    database as NoteDatabase}

        }
    }


}


