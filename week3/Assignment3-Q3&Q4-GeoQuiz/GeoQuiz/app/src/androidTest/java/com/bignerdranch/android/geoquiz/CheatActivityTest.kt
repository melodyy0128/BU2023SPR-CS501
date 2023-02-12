package com.bignerdranch.android.geoquiz

import androidx.test.core.app.ActivityScenario
import org.junit.Assert.*

import org.junit.After
import org.junit.Before

class CheatActivityTest {

    private lateinit var scenario: ActivityScenario<CheatActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(CheatActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    // rotatedStillCheating

    // showOnlyWhenCheated

    // onceCheatedAlwaysCheated

}