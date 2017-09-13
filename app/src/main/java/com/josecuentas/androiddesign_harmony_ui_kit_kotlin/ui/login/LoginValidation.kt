package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

import android.content.Context
import android.widget.Toast
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R

/**
 * Created by jcuentas on 13/09/17.
 */
class LoginValidation : LoginContract.Validation {

    private val context: Context

    constructor(context: Context) {
        this.context = context
    }

    override fun showUserNameEmptyMessage() {
        Toast.makeText(context, R.string.login_username_empty, Toast.LENGTH_SHORT).show()
    }

    override fun showPasswordEmptyMessage() {
        Toast.makeText(context, R.string.login_password_empty, Toast.LENGTH_SHORT).show()
    }
}