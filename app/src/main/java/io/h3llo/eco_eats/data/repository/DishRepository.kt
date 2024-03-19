package io.h3llo.eco_eats.data.repository

import android.content.SharedPreferences
import io.h3llo.eco_eats.core.Result
import io.h3llo.eco_eats.data.networking.Api
import io.h3llo.eco_eats.domain.model.Dish
import io.h3llo.eco_eats.domain.model.toDishList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class DishRepository @Inject constructor(val sharedPreferences: SharedPreferences)  {

    suspend fun dishes() : Flow <Result<List<Dish>>> = flow {

        // CALL API
        try {
            emit(Result.Loading())

            val token = sharedPreferences.getString("TOKEN","")

            val response = Api.build().getDishes("Bearer $token")
//          val response = Api.build().getDishes("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwianRpIjoiYjY2ZWI1MzYtMjYzNS00NTZmLTgzMzktMzg2MTNlNGUxOTBiIiwiaWF0IjoiMy8xOS8yMDI0IDI6NDc6MDcgUE0iLCJleHAiOjE3MTA4NjMyMjcsImlzcyI6IkpPVEFERVYiLCJhdWQiOiJKT1RBREVWIn0.0BtFGdCSrJJYEJk2_AaIpOkkW5g6h6K8PC0n6gAkaYQ")
            if(response.code() == 200){

                if(response.body()?.success == true ){
                    emit(Result.Success(data = response.body()?.data?.toDishList()))
                }else{
                    emit(Result.Error(message = response.body()?.message!!))
                }

            }else{
                // TODO 401

            }

        } catch (ex: IOException){
            emit(Result.Error(message = "Verifique su conexion a internet"))
        }
        catch(ex: Exception){
            emit(Result.Error(message = ex.message.toString()))
        }
    }


}