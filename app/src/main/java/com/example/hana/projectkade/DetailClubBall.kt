package com.example.hana.projectkade

import android.graphics.Typeface
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

/**
 * Created by hana on 18/11/2018.
 */

class DetailClubBall() : AppCompatActivity() {
    private lateinit var imageImageView : ImageView

    private var name : String = " "
    private lateinit var nameTextView : TextView

    private var detail : String = " "
    private lateinit var detailBola : TextView

//    constructor(parcel: Parcel) : this() {
  //      name = parcel.readString()
    //    detail = parcel.readString()
    //}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            padding = dip(12)
            //imageImageView : imageView {
              //  setImageResource(R.drawable.img_barca)
            imageImageView = imageView{
               // id = "id_klub_bola"
                setImageResource(R.drawable.img_barca) }.lparams{
                height = dip(50)
                width = dip(50)
                margin = dip(12)
                topMargin = dip (20)
                //setMargin(0,0, dip (20),0)
                gravity = Gravity.CENTER }
            nameTextView = textView{
                typeface = Typeface.DEFAULT
                gravity = Gravity.CENTER
                textSize = sp(15).toFloat()
                bottomPadding = dip (5) }.lparams{ width = wrapContent
                height = wrapContent}
            detailBola = textView {
                typeface = Typeface.DEFAULT
                textSize = dip(12).toFloat() }.lparams{
                bottomMargin = dip(7)
                width = wrapContent
                height = wrapContent}
        }
            val intent =  intent
            val name = intent.getStringExtra("name")
            nameTextView.text = name

            val detail = intent.getStringExtra("detail_grup")
            detailBola.text = detail

            imageImageView.setImageResource(intent.getIntExtra("image",R.drawable.img_barca))
    }

   // override fun writeToParcel(parcel: Parcel, flags: Int) {
     //   parcel.writeString(name)
       // parcel.writeString(detail)
    //}

//    override fun describeContents(): Int {
  //      return 0
    //}

//    companion object CREATOR : Parcelable.Creator<DetailClubBall> {
  //      override fun createFromParcel(parcel: Parcel): DetailClubBall {
    //        return DetailClubBall(parcel)
      //  }

//        override fun newArray(size: Int): Array<DetailClubBall?> {
  //          return arrayOfNulls(size)
    //    }
    //}
}