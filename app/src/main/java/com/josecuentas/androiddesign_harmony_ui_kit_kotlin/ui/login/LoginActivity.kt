package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.MainActivity
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.local.UserStore
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val presenter = LoginPresenter(this, UserStore(this, "login"))

        //When button login is clicked
        butLogin.setOnClickListener {
            val username = eteEmail.text.toString()
            val password = etePassword.text.toString()
            presenter.login(username, password)
        }
    }

    override fun showUserNameEmpty() {
        Toast.makeText(this, R.string.login_username_empty, Toast.LENGTH_SHORT).show()
    }

    override fun showPasswordEmpty() {
        Toast.makeText(this, R.string.login_password_empty, Toast.LENGTH_SHORT).show()
    }

    override fun showLoginError() {
        Toast.makeText(this, R.string.login_error, Toast.LENGTH_SHORT).show()
    }

    override fun goMain() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
    }
}
