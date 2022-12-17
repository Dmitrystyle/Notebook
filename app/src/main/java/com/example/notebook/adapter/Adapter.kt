package com.example.notebook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notebook.R
import com.example.notebook.model.Model
import com.example.notebook.screens.start.StartFragment
import java.util.Collections.emptyList

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        var itemT: TextView =itemView.findViewById(R.id.itemText1)
    }
    private var listNote = emptyList<Model>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //Откуда берем
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //привязка к сожержимому полей и нажатия по панели
        holder.itemT.text = listNote[position].title

        // holder.itemView.setOnClickListener{ Toast.makeText(context, "${userList[position].lastname}", Toast.LENGTH_SHORT).show()}

    }

    override fun getItemCount(): Int {
        //количество возвращаемого
        return  listNote.size
    }

    fun setLisrt(list: List<Model>){
        listNote=list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StartFragment.clickNote(listNote[holder.adapterPosition])}

    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.itemView.setOnClickListener(null)
    }


}