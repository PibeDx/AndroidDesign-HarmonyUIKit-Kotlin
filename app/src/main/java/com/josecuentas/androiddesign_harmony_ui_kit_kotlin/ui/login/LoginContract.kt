package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

/**
 * Created by jcuentas on 8/09/17.
 */
interface LoginContract {
    interface View {
//        fun showLoginMessageError(message: String)
        fun showUserNameEmpty()
//        fun showUserNameNotFoundError()
//        fun showUserNameInvalidate()
        fun showPasswordEmpty()
//        fun showPasswordInvalidate()
//        fun showLoginEmailNotValidateError()
//        fun showLoginError()
        fun goMain()
    }

    interface Listener {
        fun login(username: String, password: String)
    }
}
