package com.example.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HangmanFragment : Fragment() {

    companion object {
        fun newInstance() = HangmanFragment()
    }

    private lateinit var viewModel: HangmanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = arguments
        if (bundle != null) {
            val message = bundle!!.getString("letter")
            Log.d("TAG", "$message received")
        }
        return inflater.inflate(R.layout.fragment_hangman, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HangmanViewModel::class.java)
        // TODO: Use the ViewModel
    }

}