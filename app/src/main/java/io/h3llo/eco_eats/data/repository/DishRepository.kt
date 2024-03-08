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

            val response = Api.build().getDishes("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwianRpIjoiNTFkZTljYTgtMzFjNS00OGE3LTk0MzAtMDAxYzg3OWUzYjllIiwiaWF0IjoiMy84LzIwMjQgMToxMjozNCBQTSIsImV4cCI6MTcwOTkwNzE1NCwiaXNzIjoiSk9UQURFViIsImF1ZCI6IkpPVEFERVYifQ.dLLyXFfDnMcAkR-sd-8-5IEHPlvDBdP-mw6xpgF6ZWw")
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