package com.developer.allef.kotlincoroutines.data

import com.developer.allef.kotlincoroutines.data.model.Response
import retrofit2.http.GET

/**
 * @author allef.santos on 2019-11-24
 */
interface serviceApi {

    companion object{
        val BASE_URL = "https://rickandmortyapi.com/"
    }


    @GET("api/character/")
    suspend fun getCharacters() :Response



}