package com.assignment2.q4.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.assignment2.q4.calculator.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.calculateButton.setOnClickListener {
            val operand1Input: EditText = findViewById (R.id.operand1_number)
            Log.d(TAG, "Operand 1: ${operand1Input.text}")

            val radioGroup: RadioGroup = findViewById(R.id.operations_radio_group)
            val operation: RadioButton = findViewById(radioGroup.checkedRadioButtonId)
            Log.d(TAG, "Operation: ${operation.text}")

            val operand2Input: EditText = findViewById (R.id.operand2_number)
            Log.d(TAG, "Operand 2: ${operand2Input.text}")

            Toast.makeText(applicationContext,"On click : ${operand1Input.text} ${operation.text} ${operand2Input.text}",
                Toast.LENGTH_SHORT).show()
        }

    }
}