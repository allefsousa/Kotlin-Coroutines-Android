package com.developer.allef.kotlincoroutines.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.developer.allef.kotlincoroutines.data.model.Response
import com.developer.allef.kotlincoroutines.data.serviceApi

/**
 * @author allef.santos on 2019-11-24
 */
class CharacterRepository(private val serviceApi: serviceApi) {

    suspend fun getCharacter() = serviceApi.getCharacters()

}