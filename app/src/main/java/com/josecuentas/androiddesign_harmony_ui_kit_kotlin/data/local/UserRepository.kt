package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.local

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.model.User

/**
 * Created by jcuentas on 8/09/17.
 */
interface UserRepository {
    fun get(userId: String): User?
}