package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.widget.filter.option

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import android.graphics.*
import android.util.TypedValue
import android.graphics.Paint.ANTI_ALIAS_FLAG






/**
 * Created by iPibeDx on 15/07/17.
 */
class FilterOptionView : ConstraintLayout {

    init {
        init()
    }

    constructor(context: Context?) : super(context) {
        //init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        //init()
    }


    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        //init()
    }

    fun init() {
        val rootView = LayoutInflater.from(context).inflate(R.layout.filter_option_view, this, true)
        val layout: ConstraintLayout = rootView.findViewById(R.id.content_main)

        var previousButtomId : Int? = -1
        for (i in 1..6) {

            var anotherButton = LayoutInflater.from(context).inflate(R.layout.view_filter_button, this, false) as ImageButton
            anotherButton.id = i
            //layout.addView(anotherButton,newParams)
            layout.addView(anotherButton, anotherButton.layoutParams)

            val set = ConstraintSet()
            set.clone(layout)
            if (i == 1) set.connect(anotherButton.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, toPx(16))
            else set.connect(anotherButton.id, ConstraintSet.START, previousButtomId!!, ConstraintSet.END, toPx(16))
            set.connect(anotherButton.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, toPx())
            set.applyTo(layout)

            //if (i == 1) set.connect(anotherButton.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, toPx(16))
            //else set.connect(anotherButton.id, ConstraintSet.TOP, previousButtomId!!, ConstraintSet.BOTTOM, toPx(16))
            //set.connect(anotherButton.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, toPx(16))
            //set.connect(anotherButton.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, toPx(16))
            //set.constrainWidth(anotherButton.id, ConstraintSet.MATCH_CONSTRAINT)

            previousButtomId = anotherButton.id
        }
    }

    fun toPx(dp : Int = 0) : Int {
        val density = resources.displayMetrics.density
        return  (dp * density).toInt()

    }


}