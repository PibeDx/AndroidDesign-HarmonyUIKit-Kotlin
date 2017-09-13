package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.adapter.DiscoverAdapter
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dialog.FilterDialog
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.android.synthetic.main.toolbar_dashboard.*

/**
 * Created by jcuentas on 13/09/17.
 */
class DiscoverFragment : Fragment() {

    lateinit var discoverAdapter: DiscoverAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(context).inflate(R.layout.fragment_discover, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAdapter()
        setupRecycler()
        setupUi()
        events()

        val discovers = DiscoverDummy.getDiscovers()
        discoverAdapter.setDiscovers(discovers)
    }

    private fun events() {
        iviFilter.setOnClickListener {
            FilterDialog().show(fragmentManager, "filterDialog")
        }
    }

    private fun setupUi() {
        tviTitle.text = "Discover"
    }

    private fun setupAdapter() {
        this.discoverAdapter = DiscoverAdapter()
    }

    private fun setupRecycler() {
        rviDiscover.layoutManager = LinearLayoutManager(context)
        rviDiscover.setHasFixedSize(false)
        rviDiscover.adapter = discoverAdapter
    }
}