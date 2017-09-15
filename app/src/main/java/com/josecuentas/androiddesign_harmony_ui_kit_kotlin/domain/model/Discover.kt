package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model

import java.io.Serializable

/**
 * Created by jcuentas on 13/09/17.
 */
data class Discover(
        val discoverId: Int,
        val name: String,
        val point: Float,
        val distanceDescription: String,
        val previewPath: String
) : Serializable {
    companion object {
        val BUNDLE = ".discover"
    }
}