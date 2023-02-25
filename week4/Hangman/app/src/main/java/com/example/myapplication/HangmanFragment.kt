package com.example.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.myapplication.Interfaces.HangmanCallback
import com.example.myapplication.ViewModel.HangmanViewModel

class HangmanFragment : Fragment(), HangmanCallback {

    private lateinit var hangmanImage : ImageView

    private lateinit var model:HangmanViewModel
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

    override fun updateImage() {
        model.image_number+=1
        var image_number=model.image_number

        Log.d(this.tag,"update images $image_number")
        hangmanImage = view!!.findViewById(R.id.hangmanImage)
        when (image_number) {
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HangmanViewModel::class.java)
        // TODO: Use the ViewModel
    }

}