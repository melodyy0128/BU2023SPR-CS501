package com.bignerdranch.android.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.bignerdranch.android.temperatureconverter.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var currentC = 0.00
    var currentF = 32.00

    val df = DecimalFormat("#.##")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.celsiusBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                currentC = progress.toDouble()
                binding.celsiusValue.setText(currentC.toString())
                CtoF()
                binding.fahrenheitBar.setProgress(currentF.roundToInt())
                binding.fahrenheitValue.setText(currentF.toString())
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                showSnackbar()
            }
        })

        binding.fahrenheitBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                currentF = progress.toDouble()
                binding.fahrenheitValue.setText(currentF.toString())
                FtoC()
                binding.celsiusBar.setProgress(currentC.roundToInt())
                binding.celsiusValue.setText(currentC.toString())
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                if (currentF < 32) {
                    currentF = 32.0
                    binding.fahrenheitBar.setProgress(currentF.roundToInt())
                }
                FtoC()
                binding.fahrenheitValue.setText(currentF.toString())
                binding.celsiusBar.setProgress(currentC.roundToInt())
                binding.celsiusValue.setText(currentC.toString())

                showSnackbar()
            }
        })
    }

    private fun CtoF() {
        currentF = currentC*1.80 + 32.0
        // round to 2 decimal places
//        df.roundingMode = RoundingMode
        currentF = df.format(currentF).toDouble()
    }

    fun getFahrenheit() : Double {
        CtoF()
        return currentF
    }

    private fun FtoC() {
        currentC = (currentF-32.0)/1.80
        // round to 2 decimal places
//        df.roundingMode = RoundingMode.UP
        currentC = df.format(currentC).toDouble()
    }

    private fun showSnackbar(){
        var message = if (currentC <= 20) R.string.tooCold
        else R.string.tooHot

        Snackbar.make(binding.constraintLayout, message,
            Snackbar.LENGTH_SHORT).show()
    }
}