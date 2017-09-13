package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Discover
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.adapter.DiscoverAdapter
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dialog.FilterDialog
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.android.synthetic.main.toolbar_dashboard.*

/**
 * Created by jcuentas on 13/09/17.
 */
class DiscoverFragment : Fragment(), DiscoverContract.View {

    lateinit var discoverAdapter: DiscoverAdapter
    lateinit var presenter: DiscoverPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(context).inflate(R.layout.fragment_discover, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectPresenter()
        setupAdapter()
        setupRecycler()
        events()

        presenter.getDiscovers()
    }

    override fun onResume() {
        super.onResume()
        setupUi()
    }

    private fun injectPresenter() {
        presenter = DiscoverPresenter()
        presenter.attached(this)
    }

    private fun events() {
        iviFilter.setOnClickListener {
            FilterDialog().show(fragmentManager, "filterDialog")
        }
    }

    private fun setupUi() {
        tviTitle.text = getString(R.string.discover_toolbar_title)


        pbaDiscoverLoading.indeterminateDrawable.setColorFilter(
                ContextCompat.getColor(context, R.color.discover_progress),
                PorterDuff.Mode.SRC_IN
        )
    }

    private fun setupAdapter() {
        this.discoverAdapter = DiscoverAdapter()
    }

    private fun setupRecycler() {
        rviDiscover.layoutManager = LinearLayoutManager(context)
        rviDiscover.setHasFixedSize(false)
        rviDiscover.adapter = discoverAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroyed()
        presenter.cancelAll()
    }

    override fun showDiscoverLoading() {
        pbaDiscoverLoading.visibility = View.VISIBLE
    }

    override fun hideDiscoverLoading() {
        pbaDiscoverLoading.visibility = View.GONE
    }

    override fun loadDiscovers(discoverList: List<Discover>) {
        discoverAdapter.setDiscovers(discoverList as MutableList<Discover>)
        discoverAdapter.notifyDataSetChanged()
    }

    override fun showDiscoverError() {
        Toast.makeText(context, "showDiscoverError", Toast.LENGTH_SHORT).show()
    }
}