package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dialog.filter

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category

/**
 * Created by jcuentas on 14/09/17.
 */
class FilterPresenter : FilterContract.Presenter, FilterContract.Listener {

    private var view: FilterContract.View? = null

    private var rating: Int = 0
    private var distance: Int = 0
    private var categoryList: MutableList<Category> = ArrayList()

    override fun attached(view: FilterContract.View) {
        this.view = view
    }

    override fun detached() {
        this.view = null
    }

    override fun destroyed() {
        detached()
    }

    fun init(rating: Int, distance: Int) {
        this.rating = rating
        this.distance = distance

        this.view?.setRating(this.rating)
        this.view?.setDistance(this.distance)
        this.view?.setCategorys(categoryList)
    }

    fun loadInit() {
        this.view?.setRating(this.rating)
        this.view?.setDistance(this.distance)
        this.view?.setCategorys(categoryList)
    }

    override fun onChangeRating(rating: Int) {
        this.rating = rating
        when(this.rating) {
            1 -> this.view?.showRatingVeryBad()
            2 -> this.view?.showRatingBad()
            3 -> this.view?.showRatingNoBad()
            4 -> this.view?.showRatingNice()
            5 -> this.view?.showRatingExcellent()
            else -> this.view?.showRatingEmpty()
        }
    }

    override fun filter() {
        this.view?.onFilter(distance, rating, categoryList)
    }

    override fun onChangeDistance(distance: Int) {
        this.distance = distance
    }

    override fun onSelect(viewId: Int) {
        categoryList.add(Category(viewId, true, viewId))
    }

    override fun onUnSelect(viewId: Int) {
        val category = categoryList.find { it.viewId == viewId }
        if (category != null) {
            categoryList.remove(category)
        }
    }
}