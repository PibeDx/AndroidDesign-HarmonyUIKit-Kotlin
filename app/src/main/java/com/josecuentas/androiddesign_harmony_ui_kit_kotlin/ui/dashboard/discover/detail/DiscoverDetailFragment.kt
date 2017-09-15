package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import kotlinx.android.synthetic.main.fragment_discover_detail.*
import kotlinx.android.synthetic.main.toolbar_discover_detail.*


/**
 * Created by jcuentas on 15/09/17.
 */
class DiscoverDetailFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        events()

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.HORIZONTAL
        rviCategory.layoutManager = linearLayoutManager
        rviCategory.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun getItemCount(): Int = 5

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

            }

            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
                val view = LayoutInflater.from(context).inflate(R.layout.row_category, parent, false)
                return object : RecyclerView.ViewHolder(view){}
            }
        }
    }

    private fun events() {
        iviToolbarBack.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                activity.finish()
            }
        })
    }

}
