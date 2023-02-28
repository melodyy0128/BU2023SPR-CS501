package com.example.hangman

import android.support.test.uiautomator.UiDevice
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry

import org.junit.After
import org.junit.Before

class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private val device: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }


}