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

data class DishResponseDTO(
    val success: Boolean,
    val message: String,
    val data:List<DishDTO>
)

data class DishDTO(
    val id: Int,
    val name: String,
    val description: String,
    val thumbails: String,
    val image: String,
    val carbohydrates: Double,
    val proteins: Double,
    val price: Double,
    val rating: Double,
    val ingredients: String,
    val flagHeader: Boolean
)



// Mapper UserDTO -> User with Extension Functions

fun UserDTO.toUser() : User {
    return User(
        id = id,
        email = email,
        token = token
    )
}


