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
import com.example.hana.projectkade.R.array.detail_grup_bola
import com.example.hana.projectkade.R.array.nama_klub_bola
import com.example.hana.projectkade.R.array.gambar_klub_bola
import com.example.hana.projectkade.R.id.image
import com.example.hana.projectkade.R.id.name
import com.example.hana.projectkade.R.layout.item_row_team_football
//import com.example.hana.projectkade.RecycleViewAdapter.ViewHolder.LayoutContainer
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_row_team_football.*
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.item_row_team_football.view.*
import org.jetbrains.anko.startActivity

/**
 * Created by hana on 17/11/2018.
 */

class RecycleViewAdapter(private val context: Context, private val items: List<Item>,
                         private val listener: (Item)-> Unit)
    : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(
                item_row_team_football, parent, false))
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bindItem(items[position ],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) :  RecyclerView.ViewHolder(containerView),
            LayoutContainer {

            fun bindItem(items: Item, listener: (Item)-> Unit){
                name.text = items.name
                items.image?.let { Picasso.get().load(it).into(image) }
                containerView.setOnClickListener{
                   listener(items)
                    itemView.context.startActivity<DetailClubBall>("name" to items.name,
                            "image" to items.image,
                            "detail_grup" to items.detail_grup) }
            }
    }
}