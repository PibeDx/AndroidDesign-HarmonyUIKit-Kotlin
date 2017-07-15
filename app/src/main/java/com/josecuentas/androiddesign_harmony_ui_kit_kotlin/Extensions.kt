package com.josecuentas.androiddesign_harmony_ui_kit_kotlin

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.IntegerRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.widget.ImageButton

/**
 * Created by iPibeDx on 15/07/17.
 */

//ImageButton
fun ImageButton.setDrawableTintList(colorTintStateList: ColorStateList){
    val drawable = this.drawable
    var wrappedDrawable = DrawableCompat.wrap(drawable)
    wrappedDrawable = wrappedDrawable.mutate()
    DrawableCompat.setTintList(wrappedDrawable, colorTintStateList)
    DrawableCompat.setTintMode(wrappedDrawable, PorterDuff.Mode.SRC_IN)
    this.setImageDrawable(wrappedDrawable)
}

fun ImageButton.setBackgroundStateList(resource: Int) {
    val drawableBackground : Drawable = ContextCompat.getDrawable(context, resource)
    this.background = drawableBackground

    //background
    //imageButtom.supportBackgroundTintList = colorBackground
    //imageButtom.supportBackgroundTintMode = PorterDuff.Mode.SRC_OVER
    //OR
    //var drawableBackground : Drawable = ContextCompat.getDrawable(this, R.drawable.bg_box_filter)
    //var wrappedDrawableBackground = DrawableCompat.wrap(drawableBackground)
    //wrappedDrawableBackground = wrappedDrawableBackground.mutate()
    //DrawableCompat.setTintList(wrappedDrawableBackground, colorBackground)
    //DrawableCompat.setTintMode(wrappedDrawableBackground, PorterDuff.Mode.SRC_IN)
    //imageButtom.background = wrappedDrawableBackground
    //OR
    //val drawableBackground : Drawable = ContextCompat.getDrawable(this, R.drawable.bg_box_filter)
    //imageButtom.background = drawableBackground
}