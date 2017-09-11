package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.services

/**
 * Created by iPibeDx on 10/09/17.
 */
abstract class ServiceRequest<out T> {
    abstract fun enqueue(connectCallback: BaseConnectCallback<T>)

    abstract fun cancel()
}