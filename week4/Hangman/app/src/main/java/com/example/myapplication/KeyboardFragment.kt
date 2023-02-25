package com.example.myapplication

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableRow
import android.widget.Toast
import androidx.core.view.get
import com.example.myapplication.Interfaces.ActivityCallback
import com.example.myapplication.Interfaces.KeyboardFragmentCallback
import com.example.myapplication.ViewModel.KeyboardViewModel
import com.example.myapplication.databinding.FragmentKeyboardBinding

class KeyboardFragment : Fragment(),KeyboardFragmentCallback {

    companion object {
        fun newInstance() = KeyboardFragment()
    }

    lateinit var dataPasser: ActivityCallback

    private lateinit var viewModel: KeyboardViewModel

    private lateinit var _binding: FragmentKeyboardBinding
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as ActivityCallback
    }

    fun passData(data: String){
        dataPasser.sendCharMessage(data)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeyboardBinding.inflate(inflater, container, false)
        setButtonListeners()
//        val intent = Intent(this.context, MainActivity::class.java)
//        intent.putExtra("letter", letter.text.toString())
//        ContextCompat.startActivity(intent)

        return binding.root
    }

    fun setButtonListeners(){
        for(i in 0 until  binding.letterContainer.childCount)
        {
            val view = binding.letterContainer.getChildAt(i) as TableRow
            for(j in 0 until view.childCount)
            {
                var button=view.get(j) as Button
                button.setOnClickListener {
                    binding.z.setOnClickListener( View.OnClickListener {
                        viewModel.letterClicked(button)
                        passData(button.text.toString())})
                }
            }
        }
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KeyboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun resetButtonAvailability() {
        for(i in 0 until  binding.letterContainer.childCount)
        {
            val view = binding.letterContainer.getChildAt(i) as TableRow
            for(j in 0 until view.childCount)
            {
                var button=view.get(j) as Button
                button.isClickable=true
                button.isEnabled=true
            }
        }
    }

}
