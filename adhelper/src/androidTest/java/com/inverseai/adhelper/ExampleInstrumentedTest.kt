/*
 *
 *  * Created by Ariful Jannat Arif on 12/3/20 8:35 AM
 *  * cse.ariful@gmail.com
 *  * No man is perfect so why codes? if anything went wrong please debug
 *  * Last modified 12/3/20 8:35 AM
 *
 */

package com.inverseai.adhelper

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.inverseai.adhelper.test", appContext.packageName)
    }
}