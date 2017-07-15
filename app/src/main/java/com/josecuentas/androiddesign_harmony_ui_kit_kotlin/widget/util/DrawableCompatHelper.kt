package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.widget.util

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.widget.ImageButton

/**
 * Created by iPibeDx on 15/07/17.
 */

class DrawableCompatHelper {

    fun setDrawableTintList(imageButtom: ImageButton?, colorTint: ColorStateList?) {
        val drawable = imageButtom!!.drawable
        var wrappedDrawable = DrawableCompat.wrap(drawable)
        wrappedDrawable = wrappedDrawable.mutate()
        DrawableCompat.setTintList(wrappedDrawable, colorTint)
        DrawableCompat.setTintMode(wrappedDrawable, PorterDuff.Mode.SRC_IN)
        imageButtom.setImageDrawable(wrappedDrawable)
    }

    fun setBackgroundStateList(imageButtom: ImageButton?, resource: Int) {
        val drawableBackground: Drawable = ContextCompat.getDrawable(imageButtom!!.context, resource)
        imageButtom.background = drawableBackground
    }
}