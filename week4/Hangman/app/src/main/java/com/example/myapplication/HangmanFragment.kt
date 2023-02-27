package com.example.myapplication

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.myapplication.Interfaces.ActivityCallback
import com.example.myapplication.Interfaces.HangmanCallback
import com.example.myapplication.ViewModel.HangmanViewModel
import com.example.myapplication.databinding.FragmentHangmanBinding
import kotlin.math.ceil

class HangmanFragment : Fragment(), HangmanCallback {

    private lateinit var binding: FragmentHangmanBinding

    private lateinit var activityCallback: ActivityCallback
    companion object {
        fun newInstance() = HangmanFragment()
    }

    private lateinit var viewModel: HangmanViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityCallback = context as ActivityCallback
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = arguments
        if (bundle != null) {
            val message = bundle!!.getString("letter")
            Log.d("TAG", "$message received")
        }
        binding= FragmentHangmanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun updateImage(kill: Int) {
        Log.d(this.tag,"update images $kill")
        val hangmanImage = binding.hangmanImage
        when (kill) {
            0 -> hangmanImage.setImageResource(R.drawable.h0)
            1 -> hangmanImage.setImageResource(R.drawable.h1)
            2 -> hangmanImage.setImageResource(R.drawable.h2)
            3 -> hangmanImage.setImageResource(R.drawable.h3)
            4 -> hangmanImage.setImageResource(R.drawable.h4)
            5 -> hangmanImage.setImageResource(R.drawable.h5)
            6 -> hangmanImage.setImageResource(R.drawable.h6)
            7 -> hangmanImage.setImageResource(R.drawable.h7)
            8 -> hangmanImage.setImageResource(R.drawable.h8)
            9 -> hangmanImage.setImageResource(R.drawable.h9)
        }
    }

    override fun setCorrectCharacterAt(index: Int, char: Char) {
        var wordLineText = binding.wordLine.text.toString()
        val chars = wordLineText.toCharArray()
        Log.d("Before setting char", chars.toString())
        for (i in wordLineText.indices) {
            if (i == index * 2) {
                chars[i] = char
                Log.d("Setting char", chars.toString())
            }
        }
        wordLineText = String(chars)
        Log.d("After setting chars", wordLineText)
        binding.wordLine.text = wordLineText

        val wordDisplayWithoutWhitespace = binding.wordLine.text.toString().filter { !it.isWhitespace() }
        activityCallback.checkWinningCondition(wordDisplayWithoutWhitespace)
    }

    override fun updateWordLine(wordToDisplay: String) {
        Log.d("Updated wordLine in Hangman Fragment", wordToDisplay)
        binding.wordLine.text = wordToDisplay
    }

    override fun displayHint(hint: String) {
        Log.d("Display Hint", hint)
        Toast.makeText(this.context, hint, Toast.LENGTH_LONG).show()
    }

    override fun displayAnswerOnLose(answer: String) {
        var wordLineText = binding.wordLine.text.toString()
        val displayChars = wordLineText.toCharArray()
        val answerChars = answer.toCharArray()
        Log.d("Before setting char", displayChars.toString())
        for (i in wordLineText.indices) {
            if (i % 2 == 0) {
                displayChars[i] = answerChars[ceil(i / 2.0).toInt()]
                Log.d("Display correct char", displayChars.toString())
            }
        }
        wordLineText = String(displayChars)
        Log.d("After displaying all correct chars", wordLineText)
        binding.wordLine.text = wordLineText
    }

    override fun getCurrentResultText(): String {
        return binding.wordLine.text.toString()
    }

    override fun onResume() {
        super.onResume()
        var activity = activity as MainActivity
        activity.hangmanCallback = this
        activity.updateWordDisplay()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HangmanViewModel::class.java)
        // TODO: Use the ViewModel
    }

}