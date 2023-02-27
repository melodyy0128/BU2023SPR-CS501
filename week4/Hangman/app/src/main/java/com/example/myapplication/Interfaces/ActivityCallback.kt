package com.example.myapplication.Interfaces

interface ActivityCallback {
    fun sendCharMessage(data: String)
    fun hintPressedNumber(number: Int)
    fun clearSavedState()
    fun checkWinningCondition(wordDisplayWithoutWhitespace: String)
}