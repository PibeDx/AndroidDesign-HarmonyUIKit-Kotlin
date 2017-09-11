package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.services

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.services.contracts.ConnectService

/**
 * Created by iPibeDx on 10/09/17.
 */
abstract class BaseConnectService: ConnectService {

    private var serviceRequests: MutableList<ServiceRequest<Any>>? = null

    protected fun <T: Any> enqueue(serviceRequest: ServiceRequest<T>, baseConnectCallback: BaseConnectCallback<T>){
        if (serviceRequests == null) {
            serviceRequests = ArrayList()
        }
        serviceRequests?.add(serviceRequest)
        serviceRequest.enqueue(object : BaseConnectCallback<T> {
            override fun onSuccess(t: T) {
                dequeue(serviceRequest)
                baseConnectCallback.onSuccess(t)
            }

            override fun onFailure(serviceError: ServiceError) {
                dequeue(serviceRequest)
                baseConnectCallback.onFailure(serviceError)
            }
        })
    }

    protected fun dequeue(serviceRequest: ServiceRequest<Any>) {
        serviceRequests?.remove(serviceRequest)
    }

    override fun cancelAll() {
        serviceRequests?.forEach { it.cancel() }
        serviceRequests?.clear()

    }
}
