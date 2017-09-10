package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.local.UserRepository

/**
 * Created by jcuentas on 8/09/17.
 */
class LoginPresenter(val view: LoginContract.View, val userRepository: UserRepository) : LoginContract.Listener {

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

        val user = userRepository.get(username)
        if (user != null) {
            view.goMain()
        } else {
            view.showLoginError()
        }
    }
}