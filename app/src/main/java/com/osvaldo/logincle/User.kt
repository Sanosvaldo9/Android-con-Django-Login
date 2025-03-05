package com.osvaldo.logincle


data class IniciarSesionRequest(
    val no_control: String,
    val password: String
)

data class IniciarSesionResponse(
    val message: String,
    val token: String
)
