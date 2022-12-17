package com.example.notebook.screens.dataile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.REPOSITORY
import com.example.notebook.model.Model
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatailViewModel: ViewModel() {

    //удаляем заметки

    fun delete(model: Model, onSuccess:() -> Unit)=
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deletNote(model){
                onSuccess()
            }
        }


}