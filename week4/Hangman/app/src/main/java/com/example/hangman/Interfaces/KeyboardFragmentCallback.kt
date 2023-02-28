package com.example.hangman.Interfaces

interface KeyboardFragmentCallback {
    fun resetButtonAvailability()
    fun disableAllButtons()
    fun clearSelfStateInfo()
    fun setButtonsBeingClicked(sequence:String)
    fun setHintHitCount(count: Int)
}