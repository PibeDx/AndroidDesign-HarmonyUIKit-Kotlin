package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.data.local

import android.support.test.InstrumentationRegistry
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by jcuentas on 8/09/17.
 */
class UserStoreTest {

    @Test
    fun nullDirectory() {
        val context = InstrumentationRegistry.getTargetContext()
        val userStore = UserStore(context, null)
        assertNotNull(userStore)
        assertNotNull(userStore.users)
    }
}