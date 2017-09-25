package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model

import java.util.*

/**
 * Created by jcuentas on 25/09/17.
 */
data class Recommend(
        val recommendId: Int,
        val point: Int,
        val recommend: String,
        val timestamp: Date,
        val favoriteCount: Int,
        val autor: Autor
) {

    fun getFullName(): String = "${autor.name} ${autor.lastname}"

}