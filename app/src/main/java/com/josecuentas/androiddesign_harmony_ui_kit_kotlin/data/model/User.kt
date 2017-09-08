package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.model

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by jcuentas on 8/09/17.
 */
data class User(val userId: String, val username: String, val name: String, val lastname: String){

    constructor(): this("", "", "", "")

    //prefix
    val USER_ID_PREFIX = "user_id="
    val USERNAME_PREFIX = "username="
    val PASSWORD_PREFIX = "password="
    val NAME_PREFIX = "name="
    val LASTNAME_PREFIX = "lastname="

    fun readFromStream(stream: InputStream): User? {
        var username: String = ""
        var name: String = ""
        var lastname: String = ""
        var userId: String = ""

        val reader: BufferedReader = BufferedReader(InputStreamReader(stream))

        try {
            var line = reader.readLine()
            while (line != null) {
                line = reader.readLine()
                if (line.startsWith(USER_ID_PREFIX)){
                    userId = line.substring(USER_ID_PREFIX.length)
                }
                if (line.startsWith(USERNAME_PREFIX)){
                    username = line.substring(USERNAME_PREFIX.length)
                }
                if (line.startsWith(USERNAME_PREFIX)){
                    username = line.substring(USERNAME_PREFIX.length)
                }
                if (line.startsWith(NAME_PREFIX)) {
                    name = line.substring(NAME_PREFIX.length)
                }
                if (line.startsWith(LASTNAME_PREFIX)) {
                    lastname = line.substring(LASTNAME_PREFIX.length)
                }
            }
        } catch (e: IOException) {
            return null
        }
        return User(userId, username, name, lastname)
    }

    fun readPasswordFromStream(stream: InputStream): String? {
        var password: String = ""
        val reader: BufferedReader = BufferedReader(InputStreamReader(stream))

        try {
            var line = reader.readLine()
            while (line != null) {
                line = reader.readLine()
                if (line.startsWith(PASSWORD_PREFIX)) {
                    password = line.substring(PASSWORD_PREFIX.length)
                }
            }
        } catch (e: IOException) {
            return null
        }
        return password
    }
}