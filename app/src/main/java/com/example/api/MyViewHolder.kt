package com.example.api

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import java.util.*


class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind (item: Quote) {
        itemView.recyclerViewQuote.text = item.en
        itemView.recyclerViewAuthor.text = item.author
        itemView.starPlace.text = item.rating.toString()

    }
}