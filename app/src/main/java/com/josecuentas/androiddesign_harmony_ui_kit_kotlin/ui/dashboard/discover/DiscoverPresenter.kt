package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover

import android.os.Handler
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dialog.filter.FilterDummy

/**
 * Created by jcuentas on 13/09/17.
 */
class DiscoverPresenter : DiscoverContract.Presenter {

    private val DELAY_MILLIS = 1500L
    private var view: DiscoverContract.View? = null
    private val runnableList: MutableList<Runnable> = ArrayList()
    private val handler: Handler = Handler()

    override fun attached(view: DiscoverContract.View) {
        this.view = view
    }

    override fun detached() {
        this.view = null
    }

    override fun destroyed() {
        detached()
    }

    override fun getDiscovers() {
        this.view?.showDiscoverLoading()

        val getDiscoversRunnable = object : Runnable {
            override fun run() {
                //implement callback service
                val discovers = DiscoverDummy.getDiscovers()
                view?.loadDiscovers(discovers)
                view?.hideDiscoverLoading()
                runnableList.remove(this)
            }
        }
        runnableList.add(getDiscoversRunnable)
        handler.postDelayed(getDiscoversRunnable, DELAY_MILLIS)
    }

    override fun filter(distance: Int, progress: Int, categoriList: MutableList<Category>) {
        this.view?.showDiscoverLoading()

        val filterRunnable = object : Runnable {
            override fun run() {
                val discoverFilter = FilterDummy.getDiscoverFilter()
                val filter = discoverFilter.filter { it.point <= progress }
                view?.loadDiscovers(filter)
                view?.hideDiscoverLoading()

                runnableList.remove(this)
            }
        }
        runnableList.add(filterRunnable)
        handler.postDelayed(filterRunnable, DELAY_MILLIS)
    }

    fun cancelAll() {
        this.runnableList.forEach { handler.removeCallbacks(it) }
        this.runnableList.clear()
    }
}