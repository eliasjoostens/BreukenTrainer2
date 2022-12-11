package com.example.breukentrainer2

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
        assertEquals("com.example.breukentrainer2", appContext.packageName)
    }

    @Test
    fun useFrac() {
        // Context of the app under test.
        var frac1 = Frac(1, 2)
        var frac2 = Frac(2, 3)
        frac1 = frac1.plus(frac2)
        var frac3 = Frac(7, 6)
        assertEquals(frac1, frac3)
    }
}