package com.example.myapplication

import android.support.test.uiautomator.UiDevice
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.example.myapplication.ViewModel.CURRENT_INDEX_KEY
import com.example.myapplication.ViewModel.WordViewModel
import org.hamcrest.CoreMatchers.not

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KeyboardFragmentTest {
    private lateinit var scenario: ActivityScenario<MainActivity>
    private val device: UiDevice = UiDevice.getInstance(getInstrumentation())
    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun buttonDisabled() {
//        val fragmentArgs = bundleOf(CURRENT_INDEX_KEY to 0)
        onView(withId(R.id.n)).check(matches(isEnabled()))
        onView(withId(R.id.n)).perform(click())
        onView(withId(R.id.n)).check(matches(not(isEnabled())))
    }
    @Test
    fun afterRotationKeepStatus() {
        onView(withId(R.id.i)).perform(click())
        onView(withId(R.id.i)).check(matches(isEnabled()))
        device.setOrientationLeft()
        onView(withId(R.id.i)).check(matches(isEnabled()))
    }

    @Test
    fun newGame() {
        onView(withId(R.id.p)).perform(click())
        onView(withId(R.id.z)).perform(click())
        onView(withId(R.id.h)).perform(click())
        onView(withId(R.id.v)).perform(click())
        onView(withId(R.id.s)).perform(click())
        onView(withId(R.id.m)).perform(click())
        onView(withId(R.id.j)).perform(click())
        onView(withId(R.id.l)).perform(click())
        onView(withId(R.id.f)).perform(click())
        onView(withId(R.id.new_game_button)).perform(click())
    }
}