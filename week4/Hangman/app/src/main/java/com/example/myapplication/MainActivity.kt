package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.activity.viewModels
import com.example.myapplication.Interfaces.ActivityCallback
import com.example.myapplication.Interfaces.HangmanCallback
import com.example.myapplication.Interfaces.KeyboardFragmentCallback
import com.example.myapplication.ViewModel.WordViewModel

class MainActivity : AppCompatActivity(), ActivityCallback {

    private var kill = 0

    private val wordViewModel: WordViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private lateinit var hangmanCallback: HangmanCallback

    private lateinit var keyboardFragmentCallback: KeyboardFragmentCallback

    private val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
//        val hangmanFragment = HangmanFragment()
//        val keyboardFragment = KeyboardFragment()
//
//        fm.beginTransaction().replace(R.id.fragment_hangman, hangmanFragment).commit()
//        fm.beginTransaction().replace(R.id.fragment_keyboard, keyboardFragment).commit()

    }

    private fun getCallBackInterfaces()
    {
//        if(hangmanCallback==null)
            hangmanCallback=fm.findFragmentById(R.id.fragment_hangman) as HangmanCallback
//        if(keyboardFragmentCallback==null)
            keyboardFragmentCallback=fm.findFragmentById(R.id.fragment_keyboard) as KeyboardFragmentCallback
    }


    override fun sendCharMessage(data: String) {
        Log.d("LOG", "$data clicked")
        getCallBackInterfaces()
        hangmanCallback.setCorrectCharacterAt(0,data[0])
//        checkInput(data)

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

    private fun hangmanChangeImage(){

        getCallBackInterfaces()
        hangmanCallback.updateImage()
    }

}