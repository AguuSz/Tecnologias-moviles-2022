package com.agus.myfirstapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agus.myfirstapp.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setTitle(R.string.home_title)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnRegister.setOnClickListener {
            Snackbar.make(view, "Esta opcion estara disponible proximamente", Snackbar.LENGTH_LONG).show()
        }
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnHelp.setOnClickListener {
            Snackbar.make(view, "Clickee en alguna de las 2 opciones para continuar", Snackbar.LENGTH_LONG).show()
        }

    }
}