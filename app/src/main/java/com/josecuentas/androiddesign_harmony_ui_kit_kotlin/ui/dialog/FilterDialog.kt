package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dialog

import android.app.Dialog
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageButton
import android.view.*
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.setBackgroundStateList
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.setDrawableTintList
import kotlinx.android.synthetic.main.toolbar_dialog_filter.*
import kotlinx.android.synthetic.main.view_filter.*

/**
 * Created by jcuentas on 5/09/17.
 */
class FilterDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(context).inflate(R.layout.view_filter, container, true)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        events()
        ui()
    }

    private fun events() {
        tviToolbarCancel.setOnClickListener { dismiss() }
        tviToolbarSave.setOnClickListener { dismiss() }
    }

    private fun ui() {
        seekBar.thumbOffset = dpToPx(9)
        seekBar.setPadding(dpToPx(9),0,dpToPx(9),0)
        uiFilter()
    }

    fun uiFilter() {
        val colorTint = ContextCompat.getColorStateList(context, R.color.bg_tint_box_filter)
        val colorBackground = ContextCompat.getColorStateList(context, R.color.bg_box_filter)
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

    override fun setupDialog(dialog: Dialog?, style: Int) {
        super.setupDialog(dialog, STYLE_NO_TITLE)
    }

    override fun onResume() {
        super.onResume()
        val attributes = dialog.window.attributes
        attributes.gravity = Gravity.TOP
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT
        dialog.window.attributes = attributes
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    protected fun dpToPx(dp: Int): Int {
        return (dp.toFloat() * Resources.getSystem().getDisplayMetrics().density).toInt()
    }

}