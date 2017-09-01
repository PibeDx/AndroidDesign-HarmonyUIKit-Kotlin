package com.josecuentas.androiddesign_harmony_ui_kit_kotlin

import android.content.res.Resources
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageButton
import android.util.Log
import android.widget.RatingBar
import android.widget.SeekBar
import kotlinx.android.synthetic.main.view_filter.*



class MainActivity : AppCompatActivity() {

    lateinit var ratingBar : RatingBar
    lateinit var constraintLayout : ConstraintLayout
    lateinit var seekBar : SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectView()
        events()
        ui()
    }

    private fun events() {
        seekBar.thumbOffset = dpToPx(9)
        seekBar.setPadding(0,0,0,0)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("TAG", seekBar!!.thumbOffset.toString())
                val number = (progress * (seekBar!!.width - 2 * seekBar!!.thumbOffset)) /
                        seekBar.max
                textView.text = number.toString()
                textView.text = "${progress} %"
                val margin = dpToPx(20) * 2
                textView.x = seekBar.x + number +  seekBar.thumbOffset / 2
                //textView.translationX =
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }

    private fun injectView() {
        ratingBar = findViewById(R.id.rbaPoint)
        constraintLayout = findViewById(R.id.constraintLayout)
        seekBar = findViewById(R.id.seekBar)
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

    protected fun dpToPx(dp: Int): Int {
        return (dp.toFloat() * Resources.getSystem().getDisplayMetrics().density).toInt()
    }
}
