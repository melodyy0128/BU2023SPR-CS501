package com.example.myapplication.ViewModel

import android.content.Context
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.R

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

const val CURRENT_KILL = "CURRENT_KILL"

const val CURRENT_WORD_DISPLAY = "CURRENT_WORD_DISPLAY"

const val CURRENT_LETTER_CLICKED = "CURRENT_LETTER_CLICKED"

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


     var currentError: Int
        get() = savedStateHandle.get(CURRENT_KILL) ?: 0
        set(value) = savedStateHandle.set(CURRENT_KILL, value)

//    var currentWordDisplay: String
//        get() = savedStateHandle.get(CURRENT_WORD_DISPLAY) ?: ""
//        set(value) = savedStateHandle.set(CURRENT_KILL, value)

//    var currentLetterClicked : String
    var currentLetterClicked: String
        get() = savedStateHandle.get(CURRENT_LETTER_CLICKED) ?: ""
        set(value) = savedStateHandle.set(CURRENT_LETTER_CLICKED, value)

    val currentWordText: Int
        get() = wordList[currentIndex].textResId

    val currentWordHint: String
        get() = wordList[currentIndex].hint

    private fun rand(start: Int, end: Int): Int {
        return (start..end).random()
    }

//    private fun initWordDisplay() {
//        for (i in 0 until Context.getString(currentWordText).length)
//    }

    fun append(letter : String) {
        currentLetterClicked += letter
    }
}