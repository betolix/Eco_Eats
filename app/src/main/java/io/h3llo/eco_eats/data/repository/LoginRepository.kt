package io.h3llo.eco_eats.data.repository

import android.content.SharedPreferences
import io.h3llo.eco_eats.core.Result
import io.h3llo.eco_eats.data.model.LoginRequest
import io.h3llo.eco_eats.data.model.UserDTO
import io.h3llo.eco_eats.data.model.toUser
import io.h3llo.eco_eats.data.networking.Api
import io.h3llo.eco_eats.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class LoginRepository @Inject constructor(val sharedPreferences: SharedPreferences) {

    fun logIn( email:String, password:String) : Flow<Result<User>> = flow {

        try {

            emit(Result.Loading())

            val response = Api.build().signIn(
                LoginRequest(
                    email=email,
                    password=password
                )
            )
            if(response.body()?.success == true ){
                // USUARIO EXISTE // SAVE TOKEN TO INJECTED SHARED PREFERENCES
                sharedPreferences.edit().putString("TOKEN", response.body()?.data?.token).apply()
                emit(Result.Success(data = response.body()?.data?.toUser()))

            }else{
                // USUARIO NO EXISTE
                emit(Result.Error(message = response.body()!!.message))
            }
        }
        catch (ex:IOException){
            emit(Result.Error(message = "Verifique su conexion a internet"))
        }
        catch(ex:Exception){
            emit(Result.Error(message = ex.message.toString()))
        }

    }
}