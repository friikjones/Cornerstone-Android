package com.example.project_assignment3.database

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_assignment3.R


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textName = itemView.findViewById<TextView>(R.id.contactName)
    val cellName = itemView.findViewById<TextView>(R.id.contactCell)

}