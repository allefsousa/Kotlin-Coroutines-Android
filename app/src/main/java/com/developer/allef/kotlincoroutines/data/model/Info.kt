package com.developer.allef.kotlincoroutines.data.model

import com.google.gson.annotations.SerializedName

data class Info(

	@field:SerializedName("next")
	val next: String,

	@field:SerializedName("pages")
	val pages: Int,

	@field:SerializedName("prev")
	val prev: String,

	@field:SerializedName("count")
	val count: Int
)