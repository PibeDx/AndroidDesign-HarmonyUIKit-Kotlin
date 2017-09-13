package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover.DiscoverFragment


class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportFragmentManager.beginTransaction()
                .add(R.id.flaMaincontent, DiscoverFragment())
                .commit()
    }

    protected fun dpToPx(dp: Int): Int {
        return (dp.toFloat() * Resources.getSystem().getDisplayMetrics().density).toInt()
    }
}
