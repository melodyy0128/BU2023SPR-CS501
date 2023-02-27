package com.example.myapplication

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableRow
import androidx.core.view.get
import com.example.myapplication.Interfaces.ActivityCallback
import com.example.myapplication.Interfaces.KeyboardFragmentCallback
import com.example.myapplication.ViewModel.KeyboardViewModel
import com.example.myapplication.databinding.FragmentKeyboardBinding

class KeyboardFragment : Fragment(),KeyboardFragmentCallback {

    lateinit var dataPasser: ActivityCallback
    private lateinit var viewModel: KeyboardViewModel
    private lateinit var _binding: FragmentKeyboardBinding
    var hintButtonPressedNumber = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as ActivityCallback
    }

    fun passLetter(data: String){
        dataPasser.sendCharMessage(data)
    }

    private fun passNumberOfTimesHintPressed() {
        dataPasser.hintPressedNumber(hintButtonPressedNumber)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeyboardBinding.inflate(inflater, container, false)
        setButtonListeners()
        _binding.hintButton.setOnClickListener {
            hintButtonPressedNumber += 1
            passNumberOfTimesHintPressed()
        }

        _binding.newGameButton.setOnClickListener {
            Log.d("Clear Saved State KeyboardFragment", "Call Main Activity clearSavedState")
            dataPasser.gameReset()
        }

        return _binding.root
    }


    override fun onResume() {
        super.onResume()
        val activity = activity as MainActivity
        activity.keyboardFragmentCallback = this
        setButtonsBeingClicked(activity.wordViewModel.currentLetterClickedSequence)
//        activity.updateWordDisplay()
    }

    private fun setButtonListeners(){
        for(i in 0 until  _binding.letterContainer.childCount) {
            val view = _binding.letterContainer[i] as TableRow
            for(j in 0 until view.childCount) {
                val button=view.get(j) as Button
                button.setOnClickListener {
                    button.isEnabled=false
                    button.isClickable=false
                    dataPasser.sendCharMessage(button.text.toString())
                }
            }
        }
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KeyboardViewModel::class.java)
    }


    /**
     * call this function if you want to enable all buttons
     */
    override fun resetButtonAvailability() {
        for(i in 0 until  _binding.letterContainer.childCount) {
            val view = _binding.letterContainer.getChildAt(i) as TableRow
            for(j in 0 until view.childCount) {
                val button=view[j] as Button
                button.isClickable = true
                button.isEnabled = true
            }
        }
    }

     override fun setButtonsBeingClicked(sequence:String){
        for(i in 0 until  _binding.letterContainer.childCount) {
            val view = _binding.letterContainer.getChildAt(i) as TableRow
            for(j in 0 until view.childCount) {
                val button=view[j] as Button
                if(sequence.contains(button.text.toString()))
                {
                    button.isClickable = false
                    button.isEnabled = false
                }
            }
        }
    }
    override fun disableAllButtons() {
        for(i in 0 until  _binding.letterContainer.childCount) {
            val view = _binding.letterContainer.getChildAt(i) as TableRow
            for(j in 0 until view.childCount) {
                val button=view[j] as Button
                button.isClickable = false
                button.isEnabled = false
                var act=activity as MainActivity
                act.wordViewModel.append(button.text.toString())
            }
        }
    }


    companion object {
        fun newInstance() = KeyboardFragment()
    }

}
