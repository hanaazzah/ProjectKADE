package com.example.hana.projectkade

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.hana.projectkade.R.array.detail_grup_bola
import com.example.hana.projectkade.R.array.nama_klub_bola
import com.example.hana.projectkade.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // MyActivityUI().setContentView(this)
        initData()

//        verticalLayout{
//            lparams(wrapContent, wrapContent)
//            orientation = LinearLayout.VERTICAL
//        }
        list_grup.layoutManager = LinearLayoutManager(applicationContext)
        list_grup.adapter = RecycleViewAdapter(this, items) {
        }
    }

//    class MainActivityUI: AnkoComponent<MainActivity>{
//        override fun createView(ui: AnkoContext<MainActivity>): with(ui) {
//            verticalLayout{
//                padding = dip(18)
//                    val name = TextView{
//
//                    }
//            }
//        }
//    }



    private fun initData(){
        val detail_grup = resources.getStringArray(detail_grup_bola)
        val name = resources.getStringArray(nama_klub_bola)
        val image = resources.obtainTypedArray(R.array.gambar_klub_bola)

        items.clear()
        for(i in name.indices){
            items.add(Item(name[i], image.getResourceId(i,0),detail_grup[i])) //detailnya
        }

        //tipe Array Recycle

        image.recycle()
    }
}
