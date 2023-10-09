package com.pupup.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView



class MyAdapter(private val listItem : List<Model>,private val listener: OnItemClickListener): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_desgin,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]
        holder.titelView.text = item.title
        holder.descriptionView.text = item.description
        val color = if (position % 2 == 0) {
            // Even position, set background color to one color (e.g., white)
            ContextCompat.getColor(holder.itemView.context, R.color.even)
        } else {
            // Odd position, set background color to another color (e.g., gray)
            ContextCompat.getColor(holder.itemView.context, R.color.odd)
        }

        holder.itemView.setBackgroundColor(color)

        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titelView :TextView = itemView.findViewById(R.id.title)
        val descriptionView : TextView =itemView.findViewById(R.id.description)
        val container : LinearLayout = itemView.findViewById(R.id.container)
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}


