package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.services

/**
 * Created by iPibeDx on 10/09/17.
 */
interface BaseConnectCallback<in T> {
    fun onSuccess(t: T)
    fun onFailure(serviceError: ServiceError)
}