package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.widget.util

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.support.v4.content.ContextCompat
import android.widget.RatingBar
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R

/**
 * Created by jcuentas on 12/07/17.
 */
class RatingBarUtil {

    val ratingBar: RatingBar
    val context: Context

    constructor(ratingBar: RatingBar) {
        this.ratingBar = ratingBar
        this.context = this.ratingBar.context
    }


    fun setStartBackground() {
        var stars : LayerDrawable = ratingBar.progressDrawable as LayerDrawable
        stars.getDrawable(0).setColorFilter(ContextCompat.getColor(context, R.color.row_discover_ratingbar_start_background), PorterDuff.Mode.SRC_ATOP)
        stars.getDrawable(1).setColorFilter(ContextCompat.getColor(context, R.color.row_discover_ratingbar_start_secondary_progress), PorterDuff.Mode.SRC_ATOP)
        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(context, R.color.row_discover_ratingbar_start_progress), PorterDuff.Mode.SRC_ATOP)
    }
}