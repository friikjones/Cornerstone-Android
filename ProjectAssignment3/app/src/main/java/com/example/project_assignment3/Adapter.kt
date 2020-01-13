package com.example.project_assignment3

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_assignment3.database.ContactKt

class Adapter(private val dataSet: MutableList<ContactKt>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val contactView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false) as TextView
        return ViewHolder(contactView)

    }

    override fun getItemCount(): Int {
     return dataSet.size;
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].name;
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}