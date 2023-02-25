package com.example.myapplication

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class WordViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val wordList = listOf(
        Word(R.string.banana, "Fruit"),
        Word(R.string.apple, "Fruit"),
        Word(R.string.orange, "Color"),
        Word(R.string.cat, "Animal"),
        Word(R.string.rose, "Flower"),
        Word(R.string.tulip, "Flower"),
        Word(R.string.ixora, "Flower"),
        Word(R.string.canada, "Country"),
        Word(R.string.funny, "Emotion"),
        Word(R.string.yellow, "Color"),
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: rand(0, wordList.size - 1)
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentWordText: Int
        get() = wordList[currentIndex].textResId

    val currentWordHint: String
        get() = wordList[currentIndex].hint

    private fun rand(start: Int, end: Int): Int {
        return (start..end).random()
    }
}