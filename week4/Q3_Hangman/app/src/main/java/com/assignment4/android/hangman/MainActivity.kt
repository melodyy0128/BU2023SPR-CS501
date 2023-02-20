package com.assignment4.android.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val letterFragment = letterFragment()
        val hangman = hangman()

        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().replace(R.id.fragment_one, hangman).commit()
        fm.beginTransaction().replace(R.id.fragment_two, letterFragment).commit()

    }
}