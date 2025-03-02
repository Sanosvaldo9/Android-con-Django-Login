package com.osvaldo.logincle

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

data class TokenRequest(val username: String, val password: String)
data class TokenResponse(val access: String, val refresh: String)

interface ApiService {
    @GET("api/users/")
    fun getUsers(@Header("Authorization") token: String): Call<List<User>>

    @POST("api/token/")
    fun getToken(@Body request: TokenRequest): Call<TokenResponse>
}