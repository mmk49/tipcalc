package edu.uw.ischool.mmk49.tipcalculator

import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import java.util.Locale

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
        txt.doOnTextChanged { text, start, before, count ->
            run {
                if(text.isNullOrEmpty()) {
                    btn.isClickable = false
                } else {
                    btn.isClickable = true
                }
                val dotCheck = txt.text.toString().contains(".")
                val decimals = txt.text.toString().substringAfter(".")
                if(dotCheck && decimals.length > 2) {
                    val toString = txt.text.toString()
                    txt.setText(toString.substring(0, toString.length - 1))
                    txt.setSelection(toString.length - 1)
                }

            }
        }
        btn.setOnClickListener {
            val tip  = txt.text.toString().toDouble() * 0.15
            Toast.makeText(applicationContext, "$" + String.format(Locale.US, "%.2f", tip), Toast.LENGTH_SHORT).show()
        }

    }
}