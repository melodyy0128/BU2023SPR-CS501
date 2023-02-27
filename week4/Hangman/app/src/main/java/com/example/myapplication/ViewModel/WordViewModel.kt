package com.example.myapplication.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.R

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val CURRENT_KILL = "CURRENT_KILL"
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
        get() = savedStateHandle.get<Int>(CURRENT_INDEX_KEY)?: rand(0, wordList.size - 1)
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

     var currentError: Int
        get() = savedStateHandle.get<Int>(CURRENT_KILL) ?: 0
        set(value) = savedStateHandle.set(CURRENT_KILL, value)

    var currentWordDisplay: String
        get() = savedStateHandle.get<String>(CURRENT_WORD_DISPLAY) ?: initWordDisplay()
        set(value) = savedStateHandle.set(CURRENT_WORD_DISPLAY, value)

    var currentLetterClicked: String
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
//        Log.d("Word View Model initWordDisplay", ctx!!.getString(currentWordText))
//        for (i in 0 until ctx!!.getString(currentWordText).length) {
//            wordDisplay += "_ "
//        }

        return wordDisplay
    }

    fun append(letter : String) {
        currentLetterClicked += letter
    }

    fun clearSavedState() {
        Log.d("Clear Word View Model", "Clearing saved states in word view model")
        onCleared()
    }
}