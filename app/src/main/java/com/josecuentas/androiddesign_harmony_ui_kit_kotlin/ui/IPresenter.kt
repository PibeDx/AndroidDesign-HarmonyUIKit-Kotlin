package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui

/**
 * Created by jcuentas on 13/09/17.
 */
interface IPresenter<View> {
    fun attached(view: View)
    fun detached()
    fun destroyed()
}