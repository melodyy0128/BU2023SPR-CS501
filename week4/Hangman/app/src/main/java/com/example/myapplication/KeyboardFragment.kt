package com.example.myapplication

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.FragmentKeyboardBinding

class KeyboardFragment : Fragment() {

    companion object {
        fun newInstance() = KeyboardFragment()
    }

    private lateinit var viewModel: KeyboardViewModel

    private var _binding: FragmentKeyboardBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeyboardBinding.inflate(inflater, container, false)
        binding.a.setOnClickListener( View.OnClickListener {
            viewModel.letterClicked(binding.a) }
        )

        val intent = Intent(this.context, MainActivity::class.java)
        intent.putExtra("letter", letter.text.toString())
        ContextCompat.startActivity(intent)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KeyboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
