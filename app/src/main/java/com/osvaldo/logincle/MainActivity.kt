package com.osvaldo.logincle

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val token = "Token tu_token_aqui" // Reemplázalo con un token válido

        RetrofitClient.instance.getUsers(token).enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    users?.forEach {
                        Log.d("User", "ID: ${it.id}, Name: ${it.username}")
                    }
                } else {
                    Log.e("Error", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("Error", "Failure: ${t.message}")
            }
        })

        RetrofitClient.instance.getToken(TokenRequest("usuario", "contrasena"))
            .enqueue(object : Callback<TokenResponse> {
                override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                    if (response.isSuccessful) {
                        val token = response.body()?.access
                        Log.d("Auth", "Token: $token")
                    } else {
                        Log.e("Auth", "Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    Log.e("Auth", "Failure: ${t.message}")
                }
            })
    }
}