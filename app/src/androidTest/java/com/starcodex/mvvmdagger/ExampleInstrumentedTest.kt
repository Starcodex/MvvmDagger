package com.starcodex.mvvmdagger


import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@SmallTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    val appContext = InstrumentationRegistry.getTargetContext()


    @Test
    fun useAppContext() {
        // Context of the app under test.
        assertEquals("com.starcodex.mvvmdagger", appContext.packageName)
    }


}
