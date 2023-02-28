package com.bignerdranch.android.criminalintent

import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import android.support.test.uiautomator.UiDevice
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CrimeListFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


//    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var viewModel: CrimeListViewModel
    val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    val normal_crime_idx = 0
    val serious_crime_idx = 10



    @Before
    fun setUp() {
//        scenario = ActivityScenario.launch(MainActivity::class.java)

    }

    @After
    fun tearDown() {
//        scenario.close()
    }

    @Test
    fun listFragmentDisplayed() {
        onView(withId(R.id.crime_recycler_view)).check(matches(isDisplayed()))
    }

//    @Test
//    fun diffToast() {
//        viewModel = CrimeListViewModel()
//
//        val serious_crime = viewModel.crimes[serious_crime_idx]
//        val normal_crime = viewModel.crimes[normal_crime_idx]
//
//        onView(withId(R.id.crime_recycler_view)).perform(actionOnItemAtPosition<CrimeHolder>())
//    }

    // List is still shown at same index after rotation
    @Test
    fun rotatedList() {
        device.setOrientationLeft()
        device.setOrientationNatural()
    }


}