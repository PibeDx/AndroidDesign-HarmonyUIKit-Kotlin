package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.adapter

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category

/**
 * Created by iPibeDx on 18/09/17.
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    var categoryList: MutableList<Category>
    lateinit var context: Context


    constructor() : super() {
        categoryList = ArrayList()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.context = recyclerView.context
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder?, position: Int) {
        val category = categoryList.get(position)
        holder?.apply {
            iviRowCategory.setImageResource(category.resourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryAdapter.CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_category, parent, false)
        return CategoryViewHolder(view)
    }

    inner class CategoryViewHolder : RecyclerView.ViewHolder {

        val iviRowCategory: AppCompatImageView

        constructor(itemView: View) : super(itemView) {
            iviRowCategory = itemView.findViewById(R.id.iviRowCategory)
        }
    }
}