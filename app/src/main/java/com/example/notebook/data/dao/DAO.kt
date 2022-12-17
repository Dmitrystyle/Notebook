package com.example.notebook.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notebook.model.Model


@Dao

interface DAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)

    suspend fun insert(model: Model)


    @Delete

    suspend fun delete(model: Model)

    @Query("SELECT * from note_table")

    fun getAllNotes(): LiveData<List<Model>>
}

