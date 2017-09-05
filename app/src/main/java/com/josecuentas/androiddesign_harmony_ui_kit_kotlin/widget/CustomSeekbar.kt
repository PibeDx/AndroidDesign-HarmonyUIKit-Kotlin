package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.AppCompatSeekBar
import android.util.AttributeSet
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R

/**
 * Created by jcuentas on 1/09/17.
 */
class CustomSeekbar : AppCompatSeekBar {

    lateinit var mThumbPaintText: Paint
    lateinit var mThumb: Drawable

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context,
            attrs, defStyleAttr) {
        init()
    }

    fun init() {
        mThumbPaintText = Paint()
        mThumbPaintText.color = Color.BLACK
        mThumbPaintText.textSize = resources.getDimension(R.dimen.seekbar_thumb_text_size)
        //region suavizado del texto
        //mThumbPaintText.flags = Paint.LINEAR_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG
        //or
        mThumbPaintText.style = Paint.Style.FILL
        mThumbPaintText.isAntiAlias = true
        //endregion
        mThumbPaintText.textAlign = Paint.Align.CENTER
        //mThumbPaintText.isFakeBoldText = true //Hace negrita el texto
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //val thumb_x = (this.progress.toDouble() / this.max * this.width.toDouble()).toFloat()
        //val middle = this.height.toFloat() / 2

        val boundsThumb = this.mThumb.bounds as Rect
        val thumbX = boundsThumb.centerX().toFloat()
        val thumbY = boundsThumb.centerY().toFloat()
        canvas!!.drawText(this.progress.toString(), thumbX, thumbY, mThumbPaintText)
    }

    override fun setThumb(thumb: Drawable?) {
        super.setThumb(thumb)
        mThumb = thumb!!
    }

    fun getSeekBarThumb(): Drawable {
        return mThumb
    }
}