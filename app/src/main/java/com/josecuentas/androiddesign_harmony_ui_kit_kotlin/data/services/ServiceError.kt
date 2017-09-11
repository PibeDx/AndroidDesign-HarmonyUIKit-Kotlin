package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.services

/**
 * Created by iPibeDx on 10/09/17.
 */
class ServiceError {

    val UNKNOWN = 0
    val CANCELLED = 1
    val INVALID_TOKEN = 401

    private var responseCode: Int? = -1
    private var detail: String? = null

    constructor(responseCode: Int?, detailt: String?) {
        this.responseCode = responseCode
        this.detail = detailt
    }

    fun setResponseCode(responseCode: Int?) {
        this.responseCode = responseCode
    }

    fun getResponseCode(): Int? {
        return this.responseCode
    }

    fun getDetail(): String? {
        return this.detail
    }
}