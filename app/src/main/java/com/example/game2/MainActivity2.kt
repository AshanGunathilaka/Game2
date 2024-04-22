package com.example.game2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private var orangeCount = 0
    private var appleCount = 0
    private lateinit var orangeCountTextView: TextView
    private lateinit var appleCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        orangeCountTextView = findViewById<TextView>(R.id.count_textView1)
        appleCountTextView = findViewById<TextView>(R.id.count_textView2)

        setupFruitClickListener(findViewById(R.id.orange1))
        setupFruitClickListener(findViewById(R.id.orange2))
        setupFruitClickListener(findViewById(R.id.orange3))
        setupFruitClickListener(findViewById(R.id.orange4))

        setupFruitClickListener(findViewById(R.id.apple1))
        setupFruitClickListener(findViewById(R.id.apple2))
        setupFruitClickListener(findViewById(R.id.apple3))
        setupFruitClickListener(findViewById(R.id.apple4))

        // Initialize count TextViews
        updateCountTextViews()
    }

    private fun setupFruitClickListener(fruit: ImageView) {
        fruit.setOnClickListener {
            // Toggle the selected state of the fruit
            fruit.isSelected = !fruit.isSelected

            // Update the count based on the type of fruit
            if (fruit.id in listOf(R.id.orange1, R.id.orange2, R.id.orange3, R.id.orange4)) {
                if (fruit.isSelected) {
                    orangeCount++
                } else {
                    orangeCount--
                }
            } else if (fruit.id in listOf(R.id.apple1, R.id.apple2, R.id.apple3, R.id.apple4)) {
                if (fruit.isSelected) {
                    appleCount++
                } else {
                    appleCount--
                }
            }

            // Update the count TextViews
            updateCountTextViews()
        }
    }

    private fun updateCountTextViews() {
        orangeCountTextView.text = orangeCount.toString()
        appleCountTextView.text = appleCount.toString()
    }
}
