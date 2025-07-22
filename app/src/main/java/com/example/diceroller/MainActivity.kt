package com.example.diceroller

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private const val INIT_MODIFIER: Int = 0

class MainActivity : AppCompatActivity() {
    private var modifier: Int = INIT_MODIFIER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rollResult: TextView = findViewById(R.id.rollResult)

        val buttonD20: ImageButton = findViewById(R.id.button_d20)
        buttonD20.setOnClickListener {
            val result = rollDie(20) + modifier
            rollResult.text = result.toString()
        }

        val buttonD6: ImageButton = findViewById(R.id.button_d6)
        buttonD6.setOnClickListener {
            val result = rollDie(6) + modifier
            rollResult.text = result.toString()
        }
    }

    private fun rollDie(sides: Int): Int {
        return (1..sides).random()
    }
}