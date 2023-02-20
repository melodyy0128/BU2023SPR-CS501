package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hangmanFragment = HangmanFragment()
        val keyboardFragment = KeyboardFragment()


        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().replace(R.id.fragment_hangman, hangmanFragment).commit()
        fm.beginTransaction().replace(R.id.fragment_keyboard, keyboardFragment).commit()
    }
}