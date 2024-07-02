package com.yashbhalodiya.abc.contact

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yashbhalodiya.abc.databinding.ContactListModelBinding

class ContactApadter(var context: Context, var datalist : ArrayList<ContactModel>) : RecyclerView.Adapter<ContactApadter.MyViewHolder>() {
    inner class MyViewHolder(var binding : ContactListModelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = ContactListModelBinding.inflate(LayoutInflater.from(context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleTxt.text = datalist.get(position).name
        holder.binding.subTitleTxt.text = datalist.get(position).number.toString()
    }
}