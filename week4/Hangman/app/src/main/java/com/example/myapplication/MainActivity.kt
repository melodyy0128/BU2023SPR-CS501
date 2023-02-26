package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.activity.viewModels
import com.example.myapplication.Interfaces.ActivityCallback
import com.example.myapplication.Interfaces.HangmanCallback
import com.example.myapplication.Interfaces.KeyboardFragmentCallback
import com.example.myapplication.ViewModel.WordViewModel

class MainActivity : AppCompatActivity(), ActivityCallback {

    private lateinit var binding: ActivityMainBinding
    private val wordViewModel: WordViewModel by viewModels()
    private var kill = 0
    private var answer = ""
    lateinit var hangmanCallback: HangmanCallback
    lateinit var keyboardFragmentCallback: KeyboardFragmentCallback
    private val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        kill = wordViewModel.currentError
//        wordViewModel.ctx = this
        answer = wordViewModel.currentWordText
        Log.d("Answer in onCreate", answer)
        Log.d("Main activity index", wordViewModel.currentIndex.toString())
    }

    fun updateWordDisplay() {
        hangmanCallback.updateWordLine(wordViewModel.currentWordDisplay)
        Log.d("Answer in updateWordDisplay", wordViewModel.currentIndex.toString())
        Log.d("Answer in updateWordDisplay", answer)
        Log.d("Main Activity Update Word Display", wordViewModel.currentWordText)
    }


//    private fun getCallBackInterfaces() {
//            hangmanCallback = fm.findFragmentById(R.id.fragment_hangman) as HangmanCallback
//            keyboardFragmentCallback = fm.findFragmentById(R.id.fragment_keyboard) as KeyboardFragmentCallback
//    }


    override fun sendCharMessage(data: String) {
        Log.d("LOG", "$data clicked")
        wordViewModel.append(data)
//        getCallBackInterfaces()
        hangmanCallback.setCorrectCharacterAt(0,data[0])
//        checkInput(data)

    }

    override fun hintPressedNumber(number: Int) {
        if (kill == 8) {
            Toast.makeText(this, "Hint not available", Toast.LENGTH_LONG).show()
        } else {
            if (number == 1) {
                hangmanCallback.displayHint(wordViewModel.currentWordHint)
            } else if (number == 2) {
                // TODO disable half of the remaining letters in the word that are not part of the game
            } else if (number == 3) {
                // TODO Display all the vowels in the word and disable all vowels
            }
        }
    }

    override fun clearSavedState() {
        Log.d("Call Clear Word View Model", "Call clear saved states in word view model")
        wordViewModel.clearSavedState()
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
//        getCallBackInterfaces()
        hangmanCallback.updateImage()
    }

}