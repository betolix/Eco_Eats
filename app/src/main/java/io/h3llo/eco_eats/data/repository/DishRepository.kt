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

            val response = Api.build().getDishes("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwianRpIjoiNjVlZmMyN2ItNzAzZS00YThlLTkxYTktYWRjMTMyOWQ3Y2JhIiwiaWF0IjoiMy83LzIwMjQgNzoxNToxNiBQTSIsImV4cCI6MTcwOTg0MjUxNiwiaXNzIjoiSk9UQURFViIsImF1ZCI6IkpPVEFERVYifQ.4d_0qRa9OF4tu595W4ksisc6HINHlXWILdE8TdNwIJ8")
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