package io.h3llo.eco_eats.data.networking

import io.h3llo.eco_eats.data.model.LoginRequest
import io.h3llo.eco_eats.data.model.LoginResponseDTO
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

object Api {

    //url: http://betolix-001-site1.etempurl.com/api/securities/login
    //URL BASE: http://betolix-001-sitel.etempurl.com/
    // METHOD: api/securities/login
    //URL BASE + METHOD = URL COMPLETA

    val clientBuilder = OkHttpClient.Builder()
    val loggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
        clientBuilder.addInterceptor(this)
    }

    // RETORFIT CONFIGURATION
    private val builder = Retrofit.Builder()
        .baseUrl("http://betolix-001-site1.etempurl.com/")
        .client(clientBuilder.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    interface HealthyEndpoint{

        @POST("api/securities/login")
        suspend fun signIn(@Body request:LoginRequest ): Response<LoginResponseDTO>

    }

    fun build() : HealthyEndpoint{
        return builder.create(HealthyEndpoint::class.java)
    }

}