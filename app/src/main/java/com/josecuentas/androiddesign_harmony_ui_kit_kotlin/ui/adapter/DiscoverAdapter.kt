package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Discover
import com.squareup.picasso.Picasso

/**
 * Created by jcuentas on 13/09/17.
 */
class DiscoverAdapter : RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHolder> {

    private var discoverList: MutableList<Discover>? = null
    private lateinit var picasso: Picasso
    private var discoverAdapterListener: DiscoverAdapterListener?

    constructor(discoverAdapterListener: DiscoverAdapterListener) : super() {
        discoverList = ArrayList()
        this.discoverAdapterListener = discoverAdapterListener
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
        picasso = Picasso.with(recyclerView!!.context)
    }


    fun setDiscovers(discoverList: MutableList<Discover>) {
        this.discoverList = discoverList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DiscoverViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_discover, parent, false)
        return (DiscoverViewHolder(view))
    }

    override fun onBindViewHolder(holder: DiscoverViewHolder?, position: Int) {
        val discover = discoverList!!.get(position)
        //holder.iviDiscoverRow =
        holder?.apply {
            picasso.load(discover.previewPath).centerInside().fit().into(holder.iviDiscoverRow)
            tviTitleRow!!.text = discover.name
            rbaPoint!!.rating = discover.point
            tviPointRow!!.text = "${discover.point}/5.0"
            tviDistanceRow!!.text = discover.distanceDescription
            itemView.setOnClickListener {
                discoverAdapterListener?.onDiscoverDetail(discover)
            }
        }
    }

    override fun getItemCount(): Int {
        return discoverList!!.size
    }

    inner class DiscoverViewHolder : RecyclerView.ViewHolder {

        val iviDiscoverRow: ImageView
        val tviTitleRow: TextView
        val rbaPoint: RatingBar
        val tviPointRow: TextView
        val tviDistanceRow: TextView

        constructor(itemView: View?) : super(itemView) {
            iviDiscoverRow = itemView!!.findViewById(R.id.iviDiscoverRow)
            tviTitleRow = itemView!!.findViewById(R.id.tviTitleRow)
            rbaPoint = itemView!!.findViewById(R.id.rbaPoint)
            tviPointRow = itemView!!.findViewById(R.id.tviPointRow)
            tviDistanceRow = itemView!!.findViewById(R.id.tviDistanceRow)
        }

    }

    interface DiscoverAdapterListener {
        fun onDiscoverDetail(discover: Discover)
    }
}