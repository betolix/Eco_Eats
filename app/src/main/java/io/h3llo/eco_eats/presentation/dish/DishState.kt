package io.h3llo.eco_eats.presentation.dish


import io.h3llo.eco_eats.domain.model.Dish

data class DishState(
    val isLoading:Boolean=false,
    val error:String?=null,
    val dishes:List<Dish>?=null
)
