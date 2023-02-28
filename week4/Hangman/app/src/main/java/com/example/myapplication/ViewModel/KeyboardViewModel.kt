package com.example.myapplication.ViewModel

import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val HINT_BUTTON_HIT_COUNT = "HINT_BUTTON_HIT_COUNT"
class KeyboardViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var hintButtonPressedCount:Int
        get()=savedStateHandle.get<Int>(HINT_BUTTON_HIT_COUNT)?:0
        set(value) =savedStateHandle.set(HINT_BUTTON_HIT_COUNT,value)

    fun clearStateInfo(){
        savedStateHandle.remove<Int>(HINT_BUTTON_HIT_COUNT)
    }
}