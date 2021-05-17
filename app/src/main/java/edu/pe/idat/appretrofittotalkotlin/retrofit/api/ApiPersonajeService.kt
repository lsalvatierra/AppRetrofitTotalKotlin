package edu.pe.idat.appretrofittotalkotlin.retrofit.api

import edu.pe.idat.appretrofittotalkotlin.retrofit.response.ResultPersonaje
import retrofit2.Call
import retrofit2.http.GET

interface ApiPersonajeService {

    @GET("character")
    fun obtenerPersonajes() : Call<ResultPersonaje>
}