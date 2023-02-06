package com.assignment2.q4.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.assignment2.q4.calculator.databinding.ActivityMainBinding


private const val TAG = "MainActivity"
private const val OPERAND1 = "com.assignment2.q4.calculator.operand_1"
private const val OPERATION = "com.assignment2.q4.calculator.operation"
private const val OPERAND2 = "com.assignment2.q4.calculator.operand_2"
private const val RESULT = "com.assignment2.q4.calculator.result"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var operand1 = ""
    private var operation = ""
    private var operand2 = ""
    private var messageResId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val operand1Input = findViewById<EditText>(R.id.operand1_number)
        val radioGroup = findViewById<RadioGroup>(R.id.operations_radio_group)
        val operationSelected = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
        val operand2Input = findViewById<EditText>(R.id.operand2_number)
        val resultView = findViewById<TextView>(R.id.result_view)

//        if (savedInstanceState != null) {
//            operand1Input.setText(savedInstanceState.getString(OPERAND1, "") ?: "", TextView.BufferType.EDITABLE)
//            operand2Input.setText(savedInstanceState.getString(OPERAND2, "") ?: "", TextView.BufferType.EDITABLE)
//            var resultSaved = savedInstanceState.getString(RESULT)
//            resultView.text = resultSaved
//            Log.d(TAG, "result saved $resultSaved")
//        }

        binding.calculateButton.setOnClickListener {

            operand1 = operand1Input.text.toString().trim()
            Log.d(TAG, "Operand 1: $operand1")

            operation = operationSelected.text.toString().trim()
            Log.d(TAG, "Operation: $operation")

            operand2 = operand2Input.text.toString().trim()
            Log.d(TAG, "Operand 2: $operand2")

            validateInputs()
        }
    }

    private fun validateInputs() {
        Log.d(TAG, "validateInputs()")
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(OPERAND1, operand1)
//        outState.putString(OPERATION, operation)
        outState.putString(OPERAND2, operand2)
        outState.putString(RESULT, messageResId)
        Log.d(TAG, "saved result ${outState.getString(RESULT)}")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val operand1Input = findViewById<EditText>(R.id.operand1_number)
        val radioGroup = findViewById<RadioGroup>(R.id.operations_radio_group)
        val operationSelected = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
        val operand2Input = findViewById<EditText>(R.id.operand2_number)
        val resultView = findViewById<TextView>(R.id.result_view)

        operand1Input.setText(savedInstanceState.getString(OPERAND1, "") ?: "", TextView.BufferType.EDITABLE)
        operand2Input.setText(savedInstanceState.getString(OPERAND2, "") ?: "", TextView.BufferType.EDITABLE)
        var resultSaved = savedInstanceState.getString(RESULT)
        resultView.text = resultSaved
        Log.d(TAG, "result saved $resultSaved")
        super.onRestoreInstanceState(savedInstanceState);
    }
}