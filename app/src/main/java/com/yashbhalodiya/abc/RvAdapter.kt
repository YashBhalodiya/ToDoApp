package com.yashbhalodiya.abc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yashbhalodiya.abc.databinding.ListItemBinding

class RvAdapter(var context: Context, var dataList: ArrayList<RvModel>) : RecyclerView.Adapter<RvAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        var view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
//        return MyViewHolder(view)
        var binding = ListItemBinding.inflate(LayoutInflater.from(context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.textview1.text = dataList.get(position).name
        holder.binding.textview2.text = dataList.get(position).number
    }
}