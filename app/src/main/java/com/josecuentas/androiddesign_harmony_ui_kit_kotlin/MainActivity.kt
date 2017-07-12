package com.josecuentas.androiddesign_harmony_ui_kit_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RatingBar

class MainActivity : AppCompatActivity() {

    lateinit var ratingBar : RatingBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectView()
        ui()
    }

    private fun injectView() {
        ratingBar = findViewById(R.id.rbaPoint)
    }

    private fun ui() {
//        var ratingBarUtil: RatingBarUtil = RatingBarUtil(ratingBar)
//        ratingBarUtil.setStartBackground()
    }
}
