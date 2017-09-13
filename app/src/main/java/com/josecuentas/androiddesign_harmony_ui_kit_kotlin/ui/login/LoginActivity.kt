package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.login

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.MainActivity
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.local.UserStore
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        injectPresenter()
        setupUi()
        events()
    }

    private fun setupUi() {
        //region change color progressbar
        pbaLogInLoading.indeterminateDrawable.setColorFilter(
                ContextCompat.getColor(this, R.color.log_in_progress),
                PorterDuff.Mode.SRC_IN
        )
        //endregion
    }

    private fun events() {
        //When button login is clicked
        butLogin.setOnClickListener {
            val username = eteEmail.text.toString()
            val password = etePassword.text.toString()
            presenter.login(username, password)
        }
    }

    private fun injectPresenter() {
        presenter = LoginPresenter(UserStore(this, "login"), LoginValidation(this))
        presenter.attached(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyed()
        presenter.cancelAll()
    }

    override fun showLoginLoading() {
        pbaLogInLoading.visibility = View.VISIBLE
    }

    override fun hideLoginLoading() {
        pbaLogInLoading.visibility = View.GONE
    }

    override fun disableFormLogin() {
        eteEmail.isEnabled = false
        etePassword.isEnabled = false
        butLogin.isEnabled = false
    }

    override fun enableFormLogin() {
        eteEmail.isEnabled = true
        etePassword.isEnabled = true
        butLogin.isEnabled = true
    }

    override fun showLoginErrorMessage() {
        Toast.makeText(this, R.string.error_login, Toast.LENGTH_SHORT).show()
    }

    override fun goMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
