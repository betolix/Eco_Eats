package io.h3llo.eco_eats.data.repository

import io.h3llo.eco_eats.core.Result
import io.h3llo.eco_eats.data.networking.Api
import io.h3llo.eco_eats.domain.model.Dish
import io.h3llo.eco_eats.domain.model.toDishList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception

class DishRepository {

    suspend fun dishes() : Flow <Result<List<Dish>>> = flow {

        // CALL API
        try {
            emit(Result.Loading())

            val response = Api.build().getDishes("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwianRpIjoiODc2NzQzNWMtMGJlYi00M2ZiLWJhYTItMGNiZDgzM2M1OGY4IiwiaWF0IjoiMy8xMS8yMDI0IDQ6NDE6MTggQU0iLCJleHAiOjE3MTAxMzU2NzgsImlzcyI6IkpPVEFERVYiLCJhdWQiOiJKT1RBREVWIn0.zsgpy6-jLf48tTgv_h_sA5lnuY7z-hYQRcracV9A43E")
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