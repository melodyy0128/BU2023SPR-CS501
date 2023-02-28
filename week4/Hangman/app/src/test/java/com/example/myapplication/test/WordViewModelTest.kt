package com.example.myapplication.test

import androidx.lifecycle.SavedStateHandle
import com.example.myapplication.ViewModel.CURRENT_INDEX_KEY
import com.example.myapplication.ViewModel.WordViewModel
import org.junit.Assert.*
import org.junit.Test

class WordViewModelTest{

    @Test
    fun checkWordText() {
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 3))
        val wordViewModel = WordViewModel(savedStateHandle)
        assertEquals("CAT", wordViewModel.currentWordText)
    }

    @Test
    fun checkWordDisplay() {
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 4))
        val wordViewModel = WordViewModel(savedStateHandle)
        assertEquals("_ _ _ _ ", wordViewModel.currentWordDisplay)
    }

    @Test
    fun checkWordHint() {
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 9))
        val wordViewModel = WordViewModel(savedStateHandle)
        assertEquals("Color",wordViewModel.currentWordHint)
    }
}