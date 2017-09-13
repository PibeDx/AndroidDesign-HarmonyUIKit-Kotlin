package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.IPresenter

/**
 * Created by jcuentas on 8/09/17.
 */
interface LoginContract {
    interface View {
        fun showLoginLoading()
        fun hideLoginLoading()
        fun goMain()
        fun showLoginErrorMessage()
        fun disableFormLogin()
        fun enableFormLogin()
    }

    interface Validation {
        fun showUserNameEmptyMessage()
        fun showPasswordEmptyMessage()
    }

    interface Listener {

    }

    interface Presenter : IPresenter<View> {
        fun login(username: String, password: String)
    }
}
