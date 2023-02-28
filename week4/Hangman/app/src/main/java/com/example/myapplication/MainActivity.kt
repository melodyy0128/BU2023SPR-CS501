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
    val wordViewModel: WordViewModel by viewModels()
    lateinit var hangmanCallback: HangmanCallback
    lateinit var keyboardFragmentCallback: KeyboardFragmentCallback
    private val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        Log.d("Answer in onCreate", wordViewModel.currentWordText)
        Log.d("Main activity index", wordViewModel.currentIndex.toString())
    }

    fun updateWordDisplay() {
        hangmanCallback.updateWordLine(wordViewModel.currentWordDisplay)
        Log.d("Main Activity Update Word Display", wordViewModel.currentWordText)
    }

    /**
     * return where the character should be, return an empty array if character is not in target word
     */
    private fun getCharacterPosition(ch:Char,targetWord:String):List<Int>{
        val ans = arrayListOf<Int>()
        for(i in targetWord.indices) {
            if(targetWord[i] == ch) {
                ans.add(i)
            }
        }
        return ans
    }

    override fun sendCharMessage(data: String) {
        Log.d("LOG", "$data clicked")
        val res = getCharacterPosition(data[0],wordViewModel.currentWordText)
        Log.d("send char message", res.toString())
        if(res.isEmpty()) {
            //wrong answer
            wordViewModel.currentUserMistakeCount += 1
            Log.d("Update number of errors",
                wordViewModel.currentUserMistakeCount.toString())
            hangmanCallback.updateImage(wordViewModel.currentUserMistakeCount)

            if ( wordViewModel.currentUserMistakeCount == 9) {
                keyboardFragmentCallback.disableAllButtons()
                Toast.makeText(this, "You lose!", Toast.LENGTH_LONG).show()
                hangmanCallback.displayAnswerOnLose(wordViewModel.currentWordText)
            }
        } else {
            for(element in res){
                hangmanCallback.setCorrectCharacterAt(element,data[0])
            }
            wordViewModel.currentWordDisplay=hangmanCallback.getCurrentResultText()
        }
        wordViewModel.append(data)
    }

    override fun hintPressedNumber(number: Int) {
        wordViewModel.numberOfTimesHintPressed = number

        if (wordViewModel.currentUserMistakeCount == 8) {
            Toast.makeText(this, "Hint not available", Toast.LENGTH_LONG).show()
        } else {
            if (number == 1) {
                hangmanCallback.displayHint(wordViewModel.currentWordHint)
            } else if (number == 2) {
                wordViewModel.currentUserMistakeCount++
                hangmanCallback.updateImage(wordViewModel.currentUserMistakeCount)
                var str:String = ""
                var counter:Int = (26 - wordViewModel.currentLetterClickedSequence.length)/2
                for(i in 'A'.code..'Z'.code) {
                    if (counter == 0)
                        break
                    if (!wordViewModel.currentWordText.contains(i.toChar())) {
                        counter--
                        str += i.toChar()
                    }
                }
                wordViewModel.currentLetterClickedSequence += str
                keyboardFragmentCallback.setButtonsBeingClicked(str)
            } else if (number == 3) {
                // Display all the vowels in the word and disable all vowels
                wordViewModel.currentUserMistakeCount++
                hangmanCallback.updateImage(wordViewModel.currentUserMistakeCount)
                val str="AEIOU"
                for(i in str.indices) {
                    if(wordViewModel.currentWordText.contains(str[i])) {
                        val res = getCharacterPosition(str[i],wordViewModel.currentWordText)
                        for(ele in res)
                            hangmanCallback.setCorrectCharacterAt(ele,str[i])
                    }
                }
                wordViewModel.currentWordDisplay = hangmanCallback.getCurrentResultText()
                wordViewModel.currentLetterClickedSequence += str
                keyboardFragmentCallback.setButtonsBeingClicked(str)
            } else {
                Toast.makeText(this, "Hint not available", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun gameReset() {
        Log.d("MainActivity and WordViewModel clear saved state", "Replacing " +
                "hangman fragment and clearing saved states in word view model")
        wordViewModel.clearSavedState()
        hangmanCallback.updateImage(0)
        hangmanCallback.updateWordLine(wordViewModel.currentWordDisplay)
        keyboardFragmentCallback.resetButtonAvailability()
        keyboardFragmentCallback.clearSelfStateInfo()
    }

    override fun checkWinningCondition(wordDisplayWithoutWhitespace: String) {
        if (wordDisplayWithoutWhitespace == wordViewModel.currentWordText) {
            keyboardFragmentCallback.disableAllButtons()
            keyboardFragmentCallback.setHintHitCount(4)
            Toast.makeText(this, "You win!", Toast.LENGTH_LONG).show()
        }
    }


    override fun onPause() {
        super.onPause()
        wordViewModel.currentIndex = wordViewModel.currentIndex
        wordViewModel.currentUserMistakeCount = wordViewModel.currentUserMistakeCount
        wordViewModel.currentWordDisplay = wordViewModel.currentWordDisplay
        wordViewModel.currentLetterClickedSequence = wordViewModel.currentLetterClickedSequence

    }
}