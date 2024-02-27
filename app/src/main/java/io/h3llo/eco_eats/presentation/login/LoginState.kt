package io.h3llo.eco_eats.presentation.login

import io.h3llo.eco_eats.data.model.UserDTO

data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val successful: UserDTO? = null
)
