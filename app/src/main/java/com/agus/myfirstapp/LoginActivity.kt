package com.agus.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.agus.myfirstapp.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Seteamos el actionBar para tener la barra superior y poder volver
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Login"
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        // handleClickListeners
        binding.btnLogin.setOnClickListener {
            if (binding.etUsername.text.isEmpty() || binding.etPassword.text.isEmpty() || !isValid(binding.etEmail.text.toString())) {
                Snackbar.make(view, "Se deben completar los 3 campos para poder loguear", Snackbar.LENGTH_LONG).show()
            } else {
                // Logueamos
                if (!login(binding.etEmail.text.toString(), binding.etPassword.text.toString())) {
                    Snackbar.make(view, "Password incorrecta!", Snackbar.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                // Una vez logueado
                val displayText: String = "Bienvenido ${binding.etUsername.text}!"

                binding.tvWelcome.text = displayText
                binding.tvWelcome.visibility = View.VISIBLE
            }
        }
        binding.tvForgotPassword.setOnClickListener {
            if (isValid(binding.etEmail.text.toString())) {
                Snackbar.make(view, "Se ha enviado un correo a ${binding.etEmail.text} para reestablecer la password", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Ingresa un correo primero", Snackbar.LENGTH_LONG).show()
            }
        }
        binding.btnHelp.setOnClickListener {
            Snackbar.make(view, "Debe completar todos los datos para inciar sesion", Snackbar.LENGTH_LONG).show()
        }
    }

    // Se sobreescribe el metodo para cerrar la aplicacion
    override fun onBackPressed() {
        finishAffinity()
    }

    fun login(userEmail: String, userPassword: String): Boolean {
        val correctPassword: String = "passwordsegura123"

        return (userPassword == correctPassword)
    }


    // Comprueba si un email cumple con las condiciones
    fun isValid(email: String): Boolean {
        if (TextUtils.isEmpty(email)) return false

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}