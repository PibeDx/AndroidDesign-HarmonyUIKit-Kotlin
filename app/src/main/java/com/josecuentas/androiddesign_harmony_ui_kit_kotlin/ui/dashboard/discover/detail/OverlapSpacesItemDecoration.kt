package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover.detail

import android.content.res.Resources
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Created by iPibeDx on 17/09/17.
 */
class OverlapSpacesItemDecoration(val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildLayoutPosition(view) != 0) {
            outRect.left = dpToPx(space)
            //outRect.right = dpToPx(space)
            //outRect.bottom = dpToPx(space)
            //outRect.top = space
        }

    }

    protected fun dpToPx(dp: Int): Int {
        return (dp.toFloat() * Resources.getSystem().getDisplayMetrics().density).toInt()
    }
}