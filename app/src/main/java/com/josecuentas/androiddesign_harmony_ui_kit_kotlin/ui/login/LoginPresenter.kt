package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

/**
 * Created by jcuentas on 8/09/17.
 */
class LoginPresenter(val view: LoginContract.View) : LoginContract.Listener {

    override fun login(username: String, password: String) {
        // validation form
        if (username.isEmpty()) {
            view.showUserNameEmpty()
            return
        }
        if (password.isEmpty()) {
            view.showPasswordEmpty()
            return
        }
        view.goMain()
    }


}