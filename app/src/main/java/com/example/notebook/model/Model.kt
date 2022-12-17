package com.example.notebook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "note_table")

class Model (
    //генерация ключей
    @PrimaryKey(autoGenerate = true)
    var id:Int =0,

    @ColumnInfo()
    var title:String="",

    @ColumnInfo()
    var discription:String=""


) : Serializable