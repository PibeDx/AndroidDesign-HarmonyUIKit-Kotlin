package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover.detail

import android.content.res.Resources
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View


/**
 * Created by iPibeDx on 17/09/17.
 */
class GridSpacesItemDecoration(private val dpSpace: Int) : RecyclerView.ItemDecoration() {

    companion object {
        const val SPAN_COUNT = 4
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        // Add top margin only for the first item to avoid double dpSpace between items
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = 0
            outRect.left = 0
            outRect.right = 0
            outRect.bottom = dpToPx(dpSpace)
        } else if ((parent.getChildLayoutPosition(view) - 1) % SPAN_COUNT == 0) {
            outRect.top = 0
            outRect.right = dpToPx(dpSpace)
            outRect.bottom = dpToPx(dpSpace)
            outRect.left = 0
        } else if ((parent.getChildLayoutPosition(view) - 1) % SPAN_COUNT == 3) {
            outRect.top = 0
            outRect.right = 0
            outRect.left = 0
            outRect.bottom = dpToPx(dpSpace)
        } else {
            outRect.top = 0
            outRect.right = dpToPx(dpSpace)
            outRect.bottom = dpToPx(dpSpace)
            outRect.left = 0
        }
    }

    protected fun dpToPx(dp: Int): Int {
        return (dp.toFloat() * Resources.getSystem().getDisplayMetrics().density).toInt()
    }
}