package com.example.notebook.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.notebook.REPOSITORY
import com.example.notebook.data.NoteDatabase
import com.example.notebook.data.repositiry.Realisation
import com.example.notebook.model.Model

class StartViewModel(application: Application): AndroidViewModel(application) {

    //запуск базы данных
val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getDAO()
        //передача в репозиторий
        REPOSITORY=Realisation(daoNote)
    }

    fun getAllNotes():LiveData<List<Model>>{
        return REPOSITORY.allNotes
    }
}