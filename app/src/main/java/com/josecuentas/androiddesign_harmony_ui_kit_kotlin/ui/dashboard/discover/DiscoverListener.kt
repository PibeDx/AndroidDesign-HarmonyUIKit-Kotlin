package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category

/**
 * Created by jcuentas on 14/09/17.
 */
interface DiscoverListener {
    fun filter(distance: Int, progress: Int, categoriList: MutableList<Category>)
}