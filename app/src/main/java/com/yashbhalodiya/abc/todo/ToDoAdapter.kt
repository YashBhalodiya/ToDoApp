package com.yashbhalodiya.abc.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yashbhalodiya.abc.databinding.TodoItemBinding
import java.util.ArrayList

class ToDoAdapter(var context : Context,
                  var datalist : ArrayList<ToDoModel>,
                  var onDelete : (Int) -> Unit) //Callback fun to delete
    : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {
    inner class ToDoViewHolder(var binding : TodoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(context))
        return ToDoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binding.todoTitleTxt.text = datalist.get(position).title
        holder.binding.todoDescTxt.text = datalist.get(position).description
        holder.binding.deleteBtn.setOnClickListener {
            onDelete(position)
        }
    }
}