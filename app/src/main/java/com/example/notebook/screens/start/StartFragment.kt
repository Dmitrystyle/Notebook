package com.example.notebook.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notebook.APP
import com.example.notebook.R
import com.example.notebook.databinding.ActivityMainBinding
import com.example.notebook.databinding.FragmentStartBinding
import com.example.notebook.model.Model

class StartFragment : Fragment() {

    lateinit var  binding: FragmentStartBinding
    lateinit var recyclerView:RecyclerView
    lateinit var adapter1:com.example.notebook.adapter.Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentStartBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val initModel = ViewModelProvider(this).get(StartViewModel::class.java)
        initModel.initDatabase()
        recyclerView = binding.recyclerViewUser
        adapter1 = com.example.notebook.adapter.Adapter()
        recyclerView.adapter=adapter1
        initModel.getAllNotes().observe(viewLifecycleOwner,{listNotes ->
           // listNotes.asReversed()
            adapter1.setLisrt(listNotes)
        })

        binding.floatingActionButton.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addFragment)
        }
    }

    companion object{
        fun clickNote(model: Model){
            //передаем данные с модели в жругой экран через бандл
            val bundel=Bundle()
            bundel.putSerializable("note", model)
            APP.navController.navigate(R.id.action_startFragment_to_datailFragment, bundel)
        }
    }

}