package com.example.myapplication

import android.support.test.uiautomator.UiDevice
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

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