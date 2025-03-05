package com.osvaldo.logincle

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/crear-cuenta/")
    fun crearCuenta(@Body request: CrearCuentaRequest): Call<CrearCuentaResponse>
}