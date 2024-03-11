package io.h3llo.eco_eats.domain.model

import io.h3llo.eco_eats.data.model.DishDTO
import java.io.Serializable

data class Dish(
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
):Serializable

//List<DishDTO> → List<Dish>

fun List<DishDTO>.toDishList() : List<Dish> = map {
    Dish(
        id = it.id,
        name = it.name,
        description = it.description,
        thumbails = it.thumbails,
        image = it.image,
        carbohydrates = it.carbohydrates,
        proteins = it.proteins,
        price = it.price,
        rating = it.rating,
        ingredients = it.ingredients,
        flagHeader = it.flagHeader
    )
}