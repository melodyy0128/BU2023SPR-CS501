package com.example.myapplication.ViewModel

import androidx.annotation.StringRes

data class Word(@StringRes val textResId: Int, val hint: String)
