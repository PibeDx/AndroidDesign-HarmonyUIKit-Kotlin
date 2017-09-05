package com.josecuentas.androiddesign_harmony_ui_kit_kotlin

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RatingBar
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dialog.FilterDialog
import kotlinx.android.synthetic.main.toolbar_dashboard.*


class MainActivity : AppCompatActivity() {

    lateinit var ratingBar : RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectView()
        events()
        ui()
    }

    private fun events() {
        iviFilter.setOnClickListener {
            FilterDialog().show(getSupportFragmentManager(), "fiterDialog")
        }
    }

    private fun injectView() {
        ratingBar = findViewById(R.id.rbaPoint)
    }

    private fun ui() {
//        var ratingBarUtil: RatingBarUtil = RatingBarUtil(ratingBar)
//        ratingBarUtil.setStartBackground()

        tviTitle.text = "Discover"
    }

    protected fun dpToPx(dp: Int): Int {
        return (dp.toFloat() * Resources.getSystem().getDisplayMetrics().density).toInt()
    }
}
