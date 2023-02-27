package com.example.myapplication.Interfaces

interface KeyboardFragmentCallback {
    fun resetButtonAvailability()
    fun disableAllButtons()

    fun setButtonsBeingClicked(sequence:String)
}