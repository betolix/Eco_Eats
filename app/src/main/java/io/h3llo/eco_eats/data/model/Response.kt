package io.h3llo.eco_eats.data.model

data class LoginResponseDTO(
    val success: Boolean,
    val message: String,
    val data: UserDTO? = null
)

data class UserDTO(
    val id: Int,
    val email: String,
    val token: String
)

