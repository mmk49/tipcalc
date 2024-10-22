package edu.uw.ischool.mmk49.tipcalculator

import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txt = findViewById<EditText>(R.id.editTextNumberDecimal)
        val btn = findViewById<Button>(R.id.button)
        println(btn.isClickable)
        txt.doOnTextChanged { text, start, before, count ->
            run {
                if(text.isNullOrEmpty()) {
                    btn.isClickable = false
                    println(btn.isClickable)
                } else {
                    btn.isClickable = true
                    println(btn.isClickable)
                }
            }
        }
    }
}