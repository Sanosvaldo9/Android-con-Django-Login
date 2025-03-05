package com.osvaldo.logincle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ejemplo de uso
        val btnOpen = findViewById<Button>(R.id.btn_ir_registro)
        btnOpen.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)  // Inicia la nueva actividad
        }
    }
}