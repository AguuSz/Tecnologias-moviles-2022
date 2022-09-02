package com.agus.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.agus.myfirstapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.title)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // handleClickListeners
        binding.btnReset.setOnClickListener {
            Toast.makeText(baseContext, "Se clickeo el boton reset", Toast.LENGTH_LONG).show()
        }
        binding.btnLogin.setOnClickListener {
            Snackbar.make(view, "Clickeado el boton de login", Snackbar.LENGTH_LONG).show()
        }
        binding.ftButtonSettings.setOnClickListener {
            Snackbar.make(view, "Clickeado el boton de settings", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("CICLO_DE_VIDA", "ONSTART")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CICLO_DE_VIDA", "ONRESUME")
        Toast.makeText(baseContext, "Se resumio la aplicacion", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("CICLO_DE_VIDA", "ONPAUSE")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CICLO_DE_VIDA", "ONDESTROY")
    }
}