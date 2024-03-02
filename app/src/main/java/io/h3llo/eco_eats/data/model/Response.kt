package io.h3llo.eco_eats.data.model

import io.h3llo.eco_eats.domain.model.User

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

// Mapper UserDTO -> User with Extension Functions

fun UserDTO.toUser() : User {
    return User(
        id = id,
        email = email,
        token = token
    )
}


