package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.local

import android.content.Context
import android.content.res.AssetManager
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.model.User
import java.io.File
import java.io.IOException
import java.io.InputStream

/**
 * Created by jcuentas on 8/09/17.
 */
class UserStore : UserRepository {
    val users = ArrayList<User>()
    val map = HashMap<String, User>()

    constructor(context: Context, directory: String?) {
        val streams = getAssetsStreams(context.assets, directory)

        for (stream in streams) {
            val user = User().readFromStream(stream)
            if (user != null) {
                users.add(user)
                map.put(user!!.userId, user)
            }
        }

    }

    override fun get(userId: String): User? {
        return users.find { it.userId == userId }
    }

    private fun getAssetsStreams(manager: AssetManager, directory: String?): List<InputStream> {
        val filenames = getFilenames(manager, directory)
        val streams = ArrayList<InputStream>()
        for (filename in filenames) {
            val file = File(directory, filename)
            try {
                val stream = manager.open(file.getPath())
                if (stream != null) {
                    streams.add(stream)
                }
            } catch (e: IOException) {
            }

        }
        return streams
    }

    private fun getFilenames(manager: AssetManager, directory: String?): Array<String?> {
        if (directory == null) {
            return arrayOfNulls(0)
        }

        try {
            return manager.list(directory)
        } catch (e: IOException) {
            return arrayOfNulls(0)
        }

    }
}