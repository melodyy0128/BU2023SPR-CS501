package com.example.myapplication.Interfaces

interface KeyboardFragmentCallback {
    fun resetButtonAvailability()
    fun disableAllButtons()
    fun clearSelfStateInfo()
    fun setButtonsBeingClicked(sequence:String)
    fun setHintHitCount(count: Int)
}