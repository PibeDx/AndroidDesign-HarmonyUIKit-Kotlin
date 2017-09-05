package com.josecuentas.androiddesign_harmony_ui_kit_kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        events()
    }

    private fun events() {
        butLogin.setOnClickListener {

            startActivity(Intent(this@LoginActivity, MainActivity::class.java))

        }
    }
}
