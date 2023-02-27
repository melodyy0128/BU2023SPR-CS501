package com.example.myapplication.ViewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val CURRENT_ERROR = "CURRENT_ERROR"
const val CURRENT_WORD_DISPLAY = "CURRENT_WORD_DISPLAY"
const val CURRENT_LETTER_CLICKED = "CURRENT_LETTER_CLICKED"

class WordViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

//    var ctx: Context?=null
    private val wordList = listOf(
        Word("BANANA", "Fruit"),
        Word("APPLE", "Fruit"),
        Word("ORANGE", "Color"),
        Word("CAT", "Animal"),
        Word("ROSE", "Flower"),
        Word("TULIP", "Flower"),
        Word("IXORA", "Flower"),
        Word("CANADA", "Country"),
        Word("FUNNY", "Emotion"),
        Word("YELLOW", "Color"),
    )

    var currentIndex: Int
        get() = savedStateHandle.get<Int>(CURRENT_INDEX_KEY) ?: rand(0, wordList.size - 1)
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

     var currentUserMistakeCount: Int
        get() = savedStateHandle.get<Int>(CURRENT_ERROR) ?: 0
        set(value) = savedStateHandle.set(CURRENT_ERROR, value)

    var currentWordDisplay: String
        get() = savedStateHandle.get<String>(CURRENT_WORD_DISPLAY) ?: initWordDisplay()
        set(value) = savedStateHandle.set(CURRENT_WORD_DISPLAY, value)

    var currentLetterClickedSequence: String
        get() = savedStateHandle.get<String>(CURRENT_LETTER_CLICKED) ?: ""
        set(value) = savedStateHandle.set(CURRENT_LETTER_CLICKED, value)

    val currentWordText: String
        get() = wordList[currentIndex].answer

    val currentWordHint: String
        get() = wordList[currentIndex].hint

    private fun rand(start: Int, end: Int): Int {
        currentIndex=(start..end).random()
        return currentIndex
    }

    private fun initWordDisplay(): String {
        var wordDisplay = ""
        Log.d("init Word index", currentIndex.toString())
        Log.d("Word View Model initWordDisplay", currentWordText)
        for (i in currentWordText.indices) {
            wordDisplay += "_ "
        }

        return wordDisplay
    }

    fun append(letter : String) {
        currentLetterClickedSequence += letter
    }

    fun clearSavedState() {
        Log.d("Clear Word View Model", "Clearing saved states in word view model")
        savedStateHandle.remove<Int>(CURRENT_INDEX_KEY)
//        savedStateHandle.remove<Int>(CURRENT_ERROR)
//        savedStateHandle.set(CURRENT_ERROR, 0)
//        currentUserMistakeCount = savedStateHandle[CURRENT_ERROR]!!
        currentUserMistakeCount = 0
        Log.d("Current Error after resetting in WordViewModel", currentUserMistakeCount.toString())
//        savedStateHandle.remove<String>(CURRENT_LETTER_CLICKED)
        savedStateHandle.remove<String>(CURRENT_WORD_DISPLAY)
        currentLetterClickedSequence=""
    }
}