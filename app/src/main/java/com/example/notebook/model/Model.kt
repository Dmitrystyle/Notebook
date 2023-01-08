package com.example.notebook.model

import android.app.appsearch.SetSchemaResponse
import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.io.Serializable


@Entity(tableName = "note_table")

class Model (
    //генерация ключей
    @PrimaryKey(autoGenerate = true)
    var id:Int =0,

    @ColumnInfo()
    var title:String="",

    @ColumnInfo()
    var discription:String="",

    @ColumnInfo()
    var time1:Int,

    @ColumnInfo()
    var dataTime:String="",

) : Serializable

