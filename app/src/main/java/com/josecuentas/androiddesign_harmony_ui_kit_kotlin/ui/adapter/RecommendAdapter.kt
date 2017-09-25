package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.adapter

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Recommend

/**
 * Created by jcuentas on 25/09/17.
 */
class RecommendAdapter : RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder>() {

    private var recommendList: MutableList<Recommend>? = null

    fun setRecommendList(recommendList: MutableList<Recommend>) {
        this.recommendList = recommendList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_recommend, parent, false)
        return RecommendViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendViewHolder?, position: Int) {
        val recommend = recommendList!![position]
        holder?.apply {
            tviFavoriteCount.text = recommend.favoriteCount.toString()
            tviRecommendRow.text = recommend.recommend
            tviNameRow.text = recommend.getFullName()
            tviDateAgo.text = "2 HOURS AGO" //TODO: implement dateformat
            tviPointRow.text = "${recommend.point}/5"
            rbaPointRow.rating = recommend.point.toFloat()
        }
    }

    override fun getItemCount(): Int = recommendList!!.size

    inner class RecommendViewHolder : RecyclerView.ViewHolder {

        val iviProfileRow: AppCompatImageView
        val tviNameRow: TextView
        val rbaPointRow: RatingBar
        val tviPointRow: TextView
        val tviRecommendRow: TextView
        val iviFavoriteRow: AppCompatImageView
        val tviFavoriteCount: TextView
        val tviDateAgo: TextView

        constructor(itemView: View) : super(itemView) {
            iviProfileRow = itemView.findViewById(R.id.iviProfileRow)
            tviNameRow = itemView.findViewById(R.id.tviNameRow)
            rbaPointRow = itemView.findViewById(R.id.rbaPointRow)
            tviPointRow = itemView.findViewById(R.id.tviPointRow)
            tviRecommendRow = itemView.findViewById(R.id.tviRecommendRow)
            iviFavoriteRow = itemView.findViewById(R.id.iviFavoriteRow)
            tviFavoriteCount = itemView.findViewById(R.id.tviFavoriteCount)
            tviDateAgo = itemView.findViewById(R.id.tviDateAgo)
        }
    }

}