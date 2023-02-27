package com.bignerdranch.android.criminalintent

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CrimeListViewModelTest {

    private lateinit var viewModel: CrimeListViewModel

    @Before
    fun setUp() {
        viewModel = CrimeListViewModel()
    }

    @Test
    fun testCrimesListSize() {
        val expectedSize = 100
        val actualSize = viewModel.crimes.size
        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun testCrimeListContent() {
        val expectedTitle = "Crime #3"
        val expectedIsSolved = false
        val expectedRequiresPolice = 0

        val crime = viewModel.crimes[3]

        assertEquals(expectedTitle, crime.title)
        assertEquals(expectedIsSolved, crime.isSolved)
        assertEquals(expectedRequiresPolice, crime.requiresPolice)
    }
}
