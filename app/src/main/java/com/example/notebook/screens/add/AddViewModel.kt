package com.example.notebook.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.REPOSITORY
import com.example.notebook.model.Model
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel:ViewModel() {

    //добавление заметки

    fun insert(model: Model, onSuccess:() -> Unit)=
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(model){
                onSuccess()
            }
        }

}