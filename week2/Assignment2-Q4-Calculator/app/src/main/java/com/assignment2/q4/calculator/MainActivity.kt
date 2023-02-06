package com.assignment2.q4.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.assignment2.q4.calculator.databinding.ActivityMainBinding


private const val TAG = "MainActivity"
private const val RESULT = "com.assignment2.q4.calculator.result"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val calcViewModel: CalcViewModel by viewModels()
    private var operand1 = ""
    private var operation = ""
    private var operand2 = ""
    private var messageResId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        messageResId = calcViewModel.currentRes
        updateOutput()

        Log.d(TAG, "Got a CalcViewModel: $calcViewModel")

//        if (savedInstanceState != null) {
//            binding.resultView.text = savedInstanceState.getString(RESULT, "") ?: ""
//        }

        binding.calculateButton.setOnClickListener {
            val operand1Input = findViewById<EditText>(R.id.operand1_number)
            operand1 = operand1Input.text.toString().trim()
            Log.d(TAG, "Operand 1: $operand1")

            val radioGroup = findViewById<RadioGroup>(R.id.operations_radio_group)
            val operationSelected = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            operation = operationSelected.text.toString().trim()
            Log.d(TAG, "Operation: $operation")

            val operand2Input = findViewById<EditText>(R.id.operand2_number)
            operand2 = operand2Input.text.toString().trim()
            Log.d(TAG, "Operand 2: $operand2")

            validateInputs()
        }
    }

    private fun validateInputs() {
        messageResId = if (operand1 == "" || operand1 == ".") {
            getString(R.string.operand1_missing_error)
        } else if (operand2 == "" || operand2 == ".") {
            getString(R.string.operand2_missing_error)
        } else if ((operation == "/ (Divide)" || operation == "% (Modulo)") && operand2 == "0") {
            getString(R.string.divide_or_modulo_by_0_error)
        } else {
            calculate().toString()
        }

        binding.resultView.text = messageResId
        calcViewModel.updateRes(messageResId)
    }


    private fun calculate(): Float {
        val operand1Number = operand1.toFloat()
        val operand2Number = operand2.toFloat()

        val result = when(operation) {
            "+ (Add)" -> operand1Number + operand2Number
            "- (Subtract)" -> operand1Number - operand2Number
            "* (Multiply)" -> operand1Number * operand2Number
            "/ (Divide)" -> operand1Number / operand2Number
            else -> operand1Number % operand2Number
        }

        Log.d(TAG, "Result: $result")

        return result
    }

    private fun updateOutput() {
        binding.resultView.text = messageResId
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString(RESULT, messageResId)
//    }
}