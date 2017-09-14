package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Discover
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.IPresenter

/**
 * Created by jcuentas on 13/09/17.
 */
interface DiscoverContract {

    interface View {
        fun showDiscoverLoading()
        fun hideDiscoverLoading()
        fun loadDiscovers(discoverList: List<Discover>)
        fun showDiscoverError()
    }

    interface Presenter : IPresenter<View> {
        fun getDiscovers()
        fun filter(distance: Int, progress: Int, categoriList: MutableList<Category>)
    }
}