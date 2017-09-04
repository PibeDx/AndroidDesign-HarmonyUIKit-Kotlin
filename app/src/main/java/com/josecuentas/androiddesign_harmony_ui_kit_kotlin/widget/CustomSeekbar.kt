package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.AppCompatSeekBar
import android.util.AttributeSet
import android.util.Log
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R

/**
 * Created by jcuentas on 1/09/17.
 */
class CustomSeekbar : AppCompatSeekBar {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val thumb_x = (this.progress.toDouble() / this.max * this.width.toDouble()).toFloat()
        val middle = this.height.toFloat() / 2

        val paint = Paint()
        val boundsThumb = this.thumb.bounds as Rect

        Log.d("boundsThumb.toString()", boundsThumb.toString())
        Log.d("boundsThumb.centerX()", boundsThumb.centerX().toString())
        val thumbX = boundsThumb.centerX().toFloat()
        val thumbY = boundsThumb.centerY().toFloat()

        paint.setColor(Color.BLACK)
        paint.setTextSize(resources.getDimension(R.dimen.seekbar_thumb_text_size))
        paint.textAlign = Paint.Align.CENTER
        canvas!!.drawText(this.progress.toString(),
                thumbX/* + paint.measureText(this.progress.toString())/2*/,
                thumbY,
                paint)
    }
}