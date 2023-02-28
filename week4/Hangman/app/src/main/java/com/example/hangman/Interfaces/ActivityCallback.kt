package com.example.hangman.Interfaces

interface ActivityCallback {
    fun sendCharMessage(data: String)
    fun hintPressedNumber(number: Int)
    fun gameReset()
    fun checkWinningCondition(wordDisplayWithoutWhitespace: String)
}