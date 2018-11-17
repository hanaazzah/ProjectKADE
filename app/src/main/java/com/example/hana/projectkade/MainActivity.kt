package com.example.hana.projectkade

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.hana.projectkade.R.id.name
import com.example.hana.projectkade.R.id.image
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.list_grup)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecycleViewAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    private var items: MutableList<Item> = mutableListOf()

    private fun initData(){
        val name = resources.getStringArray(R.array.nama_klub_bola)
        val image = resources.obtainTypedArray(R.array.gambar_klub_bola)
        items.clear()
        for(i in name.indices){
            items.add(Item(name[i], image.getResourceId(i,0)))
        }

        //tipe Array Recycle

        image.recycle()
    }
}
