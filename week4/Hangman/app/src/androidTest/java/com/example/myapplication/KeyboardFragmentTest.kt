package com.example.myapplication

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.not

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KeyboardFragmentTest {

//    var scenario = launchFragmentInContainer<KeyboardFragment>()
    private lateinit var scenario: ActivityScenario<MainActivity>
    @Before
    fun setUp() {
//        scenario = launchFragmentInContainer<KeyboardFragment>()
//        scenario = launch(KeyboardFragment::class.java)
//            .onActivity { it.setFragment(AddNoteFragment()) }
//        ActivityScenario.launch(KeyboardFragment::class.java)
//        ActivityScenario.launch(MainActivity::class.java)
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
}