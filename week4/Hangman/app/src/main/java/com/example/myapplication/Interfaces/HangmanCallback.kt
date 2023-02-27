package com.example.myapplication.Interfaces

interface HangmanCallback {
    fun updateImage(kill: Int)
    fun setCorrectCharacterAt(index:Int, char: Char)
    fun updateWordLine(word: String)
    fun displayHint(hint: String)
    fun displayAnswerOnLose(answer: String)

    fun getCurrentResultText():String
}
