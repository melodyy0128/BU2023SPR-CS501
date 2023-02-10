package com.bignerdranch.android.geoquiz

import androidx.lifecycle.ViewModel

class CheatViewModel : ViewModel() {

    private var cheated: Boolean = false

    val didCheat: Boolean
        get() = cheated

    fun cheat() {
        this.cheated = true
    }

}