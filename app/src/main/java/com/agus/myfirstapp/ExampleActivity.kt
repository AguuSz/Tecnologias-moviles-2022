package com.agus.myfirstapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.agus.myfirstapp.utils.formatPrice
import com.agus.myfirstapp.utils.shouldChangeWater

class ExampleActivity : AppCompatActivity() {
    // El lateinit indica que es una variable que carga despues del oncreate
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_activity)
        textView = findViewById(R.id.text_1)

        if (shouldChangeWater("Sunday")) {
            textView.text = "Cambiar agua"
        } else {
            textView.text = "No cambiar agua"
        }

        findViewById<TextView>(R.id.text_2).text = "100".formatPrice()


    }
}