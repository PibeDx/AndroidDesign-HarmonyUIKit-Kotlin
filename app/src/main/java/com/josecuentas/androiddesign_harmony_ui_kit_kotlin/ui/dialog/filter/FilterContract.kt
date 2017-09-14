package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dialog.filter

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.IPresenter

/**
 * Created by jcuentas on 14/09/17.
 */
interface FilterContract {

    interface View {
        fun setDistance(distance: Int)
        fun setCategorys(list: List<Category>)
        fun setRating(rating: Int)

        fun showRatingVeryBad()
        fun showRatingBad()
        fun showRatingNoBad()
        fun showRatingNice()
        fun showRatingExcellent()
        fun showRatingEmpty()

        fun onFilter(distance: Int, progress: Int, categoriList: MutableList<Category>)
    }

    interface Listener {
        fun onChangeRating(rating: Int)
        fun onChangeDistance(distance: Int)
        fun onSelect(viewId: Int)
        fun onUnSelect(viewId: Int)
    }

    interface Presenter :IPresenter<View> {
        fun filter()
    }

}