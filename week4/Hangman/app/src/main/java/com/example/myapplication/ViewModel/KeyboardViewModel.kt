package com.example.myapplication.ViewModel

import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel

class KeyboardViewModel : ViewModel() {
    fun letterClicked(letter: Button) {
        letter.isEnabled = false
        letter.isClickable = false
    }
}