package com.example.myapplication

import androidx.annotation.StringRes

data class Word(@StringRes val textResId: Int, val hint: String)
