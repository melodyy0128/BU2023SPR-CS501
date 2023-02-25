package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivityCallback {

    private var _binding: ActivityMainBinding? = null

    private lateinit var hfcallback:HangmanCallback

    private val fm: FragmentManager = supportFragmentManager
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hangmanFragment = HangmanFragment()
        val keyboardFragment = KeyboardFragment()

        fm.beginTransaction().replace(R.id.fragment_hangman, hangmanFragment).commit()
        fm.beginTransaction().replace(R.id.fragment_keyboard, keyboardFragment).commit()
        hfcallback = fm.findFragmentById(R.id.fragment_hangman) as HangmanCallback
        hfcallback.updateImage()
    }


    override fun keyboardInterface(data: String) {
        Log.d("LOG", "$data clicked")
        val hangmanFragment = HangmanFragment()
        val bundle = Bundle()
        bundle.putString("letter", data)
        hangmanFragment.arguments = bundle
        fm.beginTransaction().replace(R.id.fragment_hangman, hangmanFragment).commit()
    }
}