package com.example.hangman.ViewModel

import androidx.lifecycle.ViewModel

class HangmanViewModel : ViewModel() {

    var image_number:Int=0
        get() = field
        set(value) {
            field = value
        }

}