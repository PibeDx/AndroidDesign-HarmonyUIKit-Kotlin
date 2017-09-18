package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover.detail

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category

/**
 * Created by iPibeDx on 18/09/17.
 */
class DiscoverDetailDummy {
    companion object {
        fun getCategorys(): List<Category> {
            val categoryList: MutableList<Category> = ArrayList<Category>()
            categoryList.add(Category(categoryId = 1, resourceId = R.drawable.ic_hiking))
            categoryList.add(Category(categoryId = 2, resourceId = R.drawable.ic_cycling))
            categoryList.add(Category(categoryId = 3, resourceId = R.drawable.ic_swimming))
            categoryList.add(Category(categoryId = 4, resourceId = R.drawable.ic_running))
            categoryList.add(Category(categoryId = 5, resourceId = R.drawable.ic_campfire))
            categoryList.add(Category(categoryId = 6, resourceId = R.drawable.ic_animal))
            return categoryList
        }


    }
}