package com.bignerdranch.android.geoquiz

import android.support.test.uiautomator.UiDevice
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class CheatActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    val device = UiDevice.getInstance(getInstrumentation())


    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    // rotatedStillCheating
    @Test
    fun rotatedStillCheating() {
        onView(withId(R.id.cheat_button)).perform(click())
        onView(withId(R.id.show_answer_button)).perform(click())
        onView(withId(R.id.answer_text_view))
            .check(matches(withText(R.string.true_button)))
        device.setOrientationLeft()
        onView(withId(R.id.answer_text_view))
            .check(matches(withText(R.string.true_button)))
        device.setOrientationNatural()
        device.pressBack()
        onView(withId(R.id.true_button)).perform(click())
        onView(withText(R.string.judgment_toast))
            .check(matches(withId(com.google.android.material.R.id.snackbar_text)))

//            .inRoot(withDecorView())

//        onView(withText(R.string.judgment_toast)).inRoot(
//            withDecorView(
//                not(
//                    `is`(
//                        MainActivity.getWindow().getDecorView()
//                    )
//                )
//            )
//        ).check(
//            matches(
//                isDisplayed()
//            )
//        )

    }

    // showOnlyWhenCheated

    // onceCheatedAlwaysCheated

}