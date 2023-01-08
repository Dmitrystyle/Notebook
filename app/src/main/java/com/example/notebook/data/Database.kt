package com.example.notebook.data

import android.content.Context
import androidx.room.*
import androidx.room.Room.databaseBuilder
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.notebook.data.dao.DAO
import com.example.notebook.model.Model
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.SynchronizedObject


@Database(entities = [Model::class], version = 3, exportSchema = false)

abstract class NoteDatabase: RoomDatabase() {

    abstract fun getDAO():DAO


    companion object{

        val MIGRATION1_2 = object : Migration(1,2){
                override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE note_table  ADD COLUMN time1 INTEGER NOT NULL DEFAULT(1)")
            }
        }

        val MIGRATION2_3 = object : Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE note_table  ADD COLUMN dataTime TEXT NOT NULL DEFAULT(1)")
            }
        }



        private var database: NoteDatabase ?=null

        @Synchronized
         fun getInstance(context:Context):NoteDatabase {
           return if (database == null) {
                database = databaseBuilder(context, NoteDatabase::class.java, "db")
                    .addMigrations(MIGRATION1_2,MIGRATION2_3)
                    .build()
                database as NoteDatabase
           }

           else
                {
                    database as NoteDatabase }

        }
    }


}





