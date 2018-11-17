package com.example.hana.projectkade

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by hana on 17/11/2018.
 */

class RecycleViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item)-> Unit) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row_team_football, parent, false))
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bindItem(items[position ],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) :  RecyclerView.ViewHolder(view){
        private val name = view.findViewById<TextView>(R.id.name)
        private val image = view.findViewById<ImageView>(R.id.image)
            fun bindItem(items: Item, listener:(Item)-> Unit){
                name.text = items.name
                items.image?.let { Picasso.get().load(it).into(image) }
                itemView.setOnClickListener{
                    listener(items)
                }
            }
    }
}
