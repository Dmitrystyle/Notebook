package com.example.notebook.data.repositiry

import androidx.lifecycle.LiveData
import com.example.notebook.data.dao.DAO
import com.example.notebook.model.Model

class Realisation(private val noteDAO: DAO):RepositoryList {
    override val allNotes: LiveData<List<Model>>
        get() = noteDAO.getAllNotes()

    override suspend fun insertNote(model: Model, onSuccess: () -> Unit) {
        noteDAO.insert(model)
        onSuccess()

    }

    override suspend fun deletNote(model: Model, onSuccess: () -> Unit) {
        noteDAO.delete(model)
        onSuccess()
    }
}