package com.assignment2.q4.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.assignment2.q4.calculator.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "************In onCreate()***************")

        binding.calculateButton.setOnClickListener {
            val operand1Input = findViewById<EditText>(R.id.operand1_number)
            Log.d(TAG, "Operand 1: ${operand1Input.text}")

            val radioGroup = findViewById<RadioGroup>(R.id.operations_radio_group)
            val operation = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            Log.d(TAG, "Operation: ${operation.text}")

            val operand2Input = findViewById<EditText>(R.id.operand2_number)
            Log.d(TAG, "Operand 2: ${operand2Input.text}")

            validateInputs(operand1Input, operation, operand2Input)
        }
    }

    private fun validateInputs(operand1: EditText, operation: RadioButton, operand2: EditText) {
        val messageResId = if (operand1.text.toString().trim() == "" || operand1.text.toString().trim() == ".") {
            getString(R.string.operand1_missing_error)
        } else if (operand2.text.toString().trim() == "" || operand2.text.toString().trim() == ".") {
            getString(R.string.operand2_missing_error)
        } else if ((operation.text.toString().trim() == "/ (Divide)" || operation.text.toString().trim() == "% (Modulo)") && operand2.text.toString().trim() == "0") {
            getString(R.string.divide_or_modulo_by_0_error)
        } else {
            calculate(operand1, operation, operand2).toString()
        }

        binding.resultView.text = messageResId
    }


    private fun calculate(operand1: EditText, operation: RadioButton, operand2: EditText): Float {
        val operand1Number = operand1.text.toString().toFloat()
        val operand2Number = operand2.text.toString().toFloat()

        val result = when(operation.text) {
            "+ (Add)" -> operand1Number + operand2Number
            "- (Subtract)" -> operand1Number - operand2Number
            "* (Multiply)" -> operand1Number * operand2Number
            "/ (Divide)" -> operand1Number / operand2Number
            else -> operand1Number % operand2Number
        }

        Log.d(TAG, "Result: $result")

        return result
    }
}