package com.bignerdranch.android.criminalintent

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class CrimeTest {

    @Test
    fun testCrimeProperties() {
        val id = UUID.randomUUID()
        val title = "Test Crime"
        val date = Date()
        val isSolved = false
        val requiresPolice = 1

        val crime = Crime(id, title, date, isSolved, requiresPolice)

        assertEquals(id, crime.id)
        assertEquals(title, crime.title)
        assertEquals(date, crime.date)
        assertEquals(isSolved, crime.isSolved)
        assertEquals(requiresPolice, crime.requiresPolice)
    }
}
