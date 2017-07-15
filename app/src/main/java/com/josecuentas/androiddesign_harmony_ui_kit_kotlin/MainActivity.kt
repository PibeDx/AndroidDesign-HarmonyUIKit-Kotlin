package com.josecuentas.androiddesign_harmony_ui_kit_kotlin

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageButton
import android.widget.RatingBar

class MainActivity : AppCompatActivity() {

    lateinit var ratingBar : RatingBar
    lateinit var constraintLayout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectView()
        ui()
    }

    private fun injectView() {
        ratingBar = findViewById(R.id.rbaPoint)
        constraintLayout = findViewById(R.id.constraintLayout)
    }

    private fun ui() {
//        var ratingBarUtil: RatingBarUtil = RatingBarUtil(ratingBar)
//        ratingBarUtil.setStartBackground()
        uiFilter()
    }

    fun uiFilter() {
        val colorTint = ContextCompat.getColorStateList(this, R.color.bg_tint_box_filter)
        val colorBackground = ContextCompat.getColorStateList(this, R.color.bg_box_filter)
        val childCount = constraintLayout.childCount

        for (index in 0..childCount - 1) {
            val imageButtom = constraintLayout.getChildAt(index)
            if (imageButtom is AppCompatImageButton) {
                imageButtom.setDrawableTintList(colorTint)
                imageButtom.setBackgroundStateList(R.drawable.bg_box_filter)
                imageButtom.setOnClickListener { it.isSelected = !it.isSelected }
            }

        }
    }
}
