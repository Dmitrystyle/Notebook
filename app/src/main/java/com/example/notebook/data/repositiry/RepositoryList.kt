package com.example.notebook.data.repositiry

import androidx.lifecycle.LiveData
import com.example.notebook.model.Model

interface RepositoryList {
    val allNotes: LiveData<List<Model>>
    suspend fun insertNote(model:Model, onSuccess:() -> Unit)
    suspend fun deletNote(model:Model, onSuccess:() -> Unit)
}