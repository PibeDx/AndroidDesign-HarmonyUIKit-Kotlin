package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model

/**
 * Created by jcuentas on 14/09/17.
 */
data class Category(val categoryId: Int, val isSeleted: Boolean = false, var viewId: Int = -1, var resourceId: Int = -1) {
}