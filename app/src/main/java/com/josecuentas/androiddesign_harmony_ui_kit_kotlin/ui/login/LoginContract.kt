package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

/**
 * Created by jcuentas on 8/09/17.
 */
interface LoginContract {
    interface View {
        fun showUserNameEmpty()
        fun showPasswordEmpty()
        fun goMain()
        fun showLoginError()
    }

    interface Listener {
        fun login(username: String, password: String)
    }
}
