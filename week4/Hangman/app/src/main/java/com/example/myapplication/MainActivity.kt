package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.activity.viewModels

class MainActivity : AppCompatActivity(), ActivityCallback {

    private var kill = 0

    private val wordViewModel: WordViewModel by viewModels()

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
    }


    override fun keyboardInterface(data: String) {
        Log.d("LOG", "$data clicked")
        checkInput(data)
    }
    //TODO:check letter with word
    //valid user's input
    private fun checkInput(letter : String) {
        val hangmanFragment = HangmanFragment()
        val bundle = Bundle()
        bundle.putString("letter", letter)
        bundle.putInt("image_number", kill)
        hangmanFragment.arguments = bundle
        fm.beginTransaction().replace(R.id.fragment_hangman, hangmanFragment).commit()
    }

}