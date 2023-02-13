package com.bignerdranch.android.temperatureconverter

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches

import androidx.test.core.app.ActivityScenario
import android.widget.SeekBar

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.action.ViewActions.click

import androidx.test.espresso.matcher.ViewMatchers.*




@RunWith(AndroidJUnit4::class)
class MainActivityTests {

    private lateinit var scenario: ActivityScenario<MainActivity>


    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }
    @Test
    fun testCelsiusConversion() {
        onView(withId(R.id.celsiusValue)).check(matches(withText("0.00")))
        onView(withId(R.id.fahrenheitValue)).check(matches(withText("32.00")))
    }

    @Test
    fun testFahrenheitConversion() {
        onView(withId(R.id.fahrenheitValue)).check(matches(withText("32.00")))
        onView(withId(R.id.celsiusValue)).check(matches(withText("0.00")))
    }





}
