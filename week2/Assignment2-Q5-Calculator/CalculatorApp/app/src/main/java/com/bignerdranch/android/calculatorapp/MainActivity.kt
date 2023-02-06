package com.bignerdranch.android.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bignerdranch.android.calculatorapp.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var operate_ch:String=""

    private var num1:Double= Double.NaN

    private var num2:Double= Double.NaN

    private var clearOpt:Boolean=true

    private var originalButtonColor=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        originalButtonColor=binding.button1.drawingCacheBackgroundColor;

        bindNumber()

        clearAll()

        bindOperation()

    }

    /**
     * This function is to display text in the parameter in the EditText
     * whose ID is resultText
     */
    private fun displayText(text: java.lang.StringBuilder){
        binding.resultText.setText(text)
    }

    /**
     * bindNumber is bind all the numbers to their corresponding functions,
     * and each function has a listener
     */
    private fun bindNumber(){
        binding.button0.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"0")
        }

        binding.button1.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"1")
        }

        binding.button2.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"2")
        }

        binding.button3.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"3")
        }

        binding.button4.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"4")
        }

        binding.button5.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"5")
        }

        binding.button6.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"6")
        }

        binding.button7.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"7")
        }

        binding.button8.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"8")
        }

        binding.button9.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            binding.resultText.setText( binding.resultText.text.toString()+"9")
        }

        binding.buttonDot.setOnClickListener {
            if(clearOpt)
            {
                binding.resultText.setText("");
                clearOpt=false
            }
            if(!binding.resultText.text.toString().contains('.'))
                binding.resultText.setText( binding.resultText.text.toString()+".")
        }


    }

    /**
     * bind operation is having functions that bind the operations.
     * Each operation has one binding function and a listener inside
     */
    private fun bindOperation(){

        binding.buttonSub.setOnClickListener {
            try{
                if (operate_ch != "" && operate_ch != "sqrt") {
                    num2 = binding.resultText.text.toString().toDouble();
                    num1 = calculate().toDouble();
                    binding.resultText.setText(num1.toString())
                    operate_ch = "-"
                    clearOpt = true
                } else {
                    operate_ch = "-"
                    clearOpt = true
                    num1 = binding.resultText.text.toString().toDouble();
                }
            }catch (error:java.lang.Exception)
            {
                Toast.makeText(this,R.string.input_error_message, Toast.LENGTH_SHORT).show()
                clearAll()
            }
        }

        binding.buttonAdd.setOnClickListener {
            try{
                if (operate_ch != "" && operate_ch != "sqrt") {
                    num2 = binding.resultText.text.toString().toDouble();
                    num1 = calculate().toDouble();
                    binding.resultText.setText(num1.toString())
                    operate_ch = "+"
                    clearOpt = true
                } else {
                    operate_ch = "+"
                    clearOpt = true
                    num1 = binding.resultText.text.toString().toDouble();
                }
            }catch (error:java.lang.Exception)
            {
                Toast.makeText(this,R.string.input_error_message, Toast.LENGTH_SHORT).show()
                clearAll()
            }
        }

        binding.buttonDiv.setOnClickListener {
            try{
                if (operate_ch != "" && operate_ch != "sqrt") {
                    num2 = binding.resultText.text.toString().toDouble();
                    num1 = calculate().toDouble();
                    binding.resultText.setText(num1.toString())
                    operate_ch = "/"
                    clearOpt = true
                } else {
                    operate_ch = "/"
                    clearOpt = true
                    num1 = binding.resultText.text.toString().toDouble();
                }
            }catch (error:java.lang.Exception)
            {
                Toast.makeText(this,R.string.input_error_message, Toast.LENGTH_SHORT).show()
                clearAll()
            }
        }

        binding.buttonMul.setOnClickListener {
            try{
                if (operate_ch != "" && operate_ch != "sqrt") {
                    num2 = binding.resultText.text.toString().toDouble();
                    num1 = calculate().toDouble();
                    binding.resultText.setText(num1.toString())
                    operate_ch = "*"
                    clearOpt = true
                } else {
                    operate_ch = "*"
                    clearOpt = true
                    num1 = binding.resultText.text.toString().toDouble();
                }
            }catch (error:java.lang.Exception)
            {
                Toast.makeText(this,R.string.input_error_message, Toast.LENGTH_SHORT).show()
                clearAll()
            }
        }

        binding.buttonSqrt.setOnClickListener {
            try{
                operate_ch = "sqrt"
                num1 = binding.resultText.text.toString().toDouble();
                binding.resultText.setText(sqrt(num1).toString())
                num1 = sqrt(num1)
                clearOpt = true
            }catch (error:java.lang.Exception)
            {
                Toast.makeText(this,R.string.input_error_message, Toast.LENGTH_SHORT).show()
                clearAll()
            }
        }

        binding.buttonEqual.setOnClickListener {
            try {
                num2=binding.resultText.text.toString().toDouble();
                binding.resultText.setText(calculate())
                clearOpt=true
                operate_ch=""
            }catch (error:java.lang.Exception)
            {
                Toast.makeText(this,R.string.input_error_message, Toast.LENGTH_SHORT).show()
                clearAll()
            }

        }
        binding.buttonClear.setOnClickListener {
            clearAll()
        }
    }

    private fun calculate():String{
        var ans=0.0
        if(operate_ch.equals("+"))
        {
            ans=num1+num2
        }else if(operate_ch.equals("-"))
        {
            ans=num1-num2
        }else if(operate_ch.equals("*"))
        {
            ans=num1*num2
        }else if(operate_ch.equals("/"))
        {
            if(num2==0.0)
            {
                Toast.makeText(this, "ERROR, 0 cannot be the divisor", Toast.LENGTH_SHORT).show()
                clearAll()
            }else {
                ans = num1 / num2
            }
        }
        num1=ans
        return ans.toString()
    }

    /**
     * This function is bind the buttonClear to a listener
     */
    private fun clearAll(){
        num1= Double.NaN
        num2=Double.NaN
        clearOpt=true
        operate_ch=""
        binding.resultText.setText("0.0")

    }

}