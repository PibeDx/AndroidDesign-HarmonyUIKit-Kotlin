package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

import android.os.Handler
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.local.UserRepository

/**
 * Created by jcuentas on 8/09/17.
 */
class LoginPresenter(val userRepository: UserRepository,
                     val validation: LoginContract.Validation) : LoginContract.Presenter {
    private val DELAY_MILLIS = 1500L
    private var view: LoginContract.View? = null
    private val runnableList: MutableList<Runnable> = ArrayList()
    private val handler: Handler = Handler()

    override fun attached(view: LoginContract.View) {
        this.view = view
    }

    override fun detached() {
        this.view = null
    }

    override fun destroyed() {
        this.detached()
    }

    override fun login(username: String, password: String) {
        view?.showLoginLoading()
        // validation form
        if (!isFormValid(username, password)){
            view?.hideLoginLoading()
            return
        }
        view?.disableFormLogin()
        //implement callback service
        val loginRunnable = object : Runnable {
            override fun run() {
                val user = userRepository.get(username)
                if (user != null) {
                    view?.hideLoginLoading()
                    view?.goMain()
                } else {
                    view?.hideLoginLoading()
                    view?.showLoginErrorMessage()
                }
                view?.enableFormLogin()
                runnableList.remove(this)
            }
        }
        runnableList.add(loginRunnable)
        handler.postDelayed(loginRunnable, DELAY_MILLIS)
    }

    fun isFormValid(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            validation?.showUserNameEmptyMessage()
            return false
        }
        if (password.isEmpty()) {
            validation?.showPasswordEmptyMessage()
            return false
        }
        return true
    }

    fun cancelAll() {
        this.runnableList.forEach {
            this.handler.removeCallbacks(it)
        }
    }
}