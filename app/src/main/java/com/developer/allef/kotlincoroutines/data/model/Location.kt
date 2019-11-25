package com.developer.allef.kotlincoroutines.data.model

import com.google.gson.annotations.SerializedName

data class Location(
	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)