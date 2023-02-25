package com.example.myapplication.Interfaces

interface HangmanCallback {
    fun updateImage()
    fun setCorrectCharacterAt(index:Int, char: Char)
}
