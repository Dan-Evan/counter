package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var counterText: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterText = findViewById(R.id.textViewCount)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        counterText.text = counter.toString()

        falseStart()

        incrementButton.setOnClickListener {
            decrementButton.isEnabled = true

            counter = increment(counter)

            if (counter >= 100) {
                incrementButton.isEnabled = false
            }
            counterText.text = counter.toString()
        }

        decrementButton.setOnClickListener {
            incrementButton.isEnabled = true

            counter = decrement(counter)

            if (counter <= 0) {
                decrementButton.isEnabled = false
            }
            counterText.text = counter.toString()
        }
    }

    private fun falseStart() {
        if (counter <= 0) {
            decrementButton.isEnabled = false
        }
    }


    private fun increment(num: Int): Int {
        var count = num
        count++

        return count
    }

    private fun decrement(num: Int): Int {
        var count = num
        count--

        return count
    }
}

