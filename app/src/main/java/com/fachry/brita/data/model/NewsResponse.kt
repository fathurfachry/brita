package com.fachry.brita.data.model

import kotlinx.parcelize.Parcelize
import com.squareup.moshi.JsonClass
import android.os.Parcelable
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
@Parcelize
data class NewsResponse(

	@Json(name="data")
	val data: Data? = null,

	@Json(name="success")
	val success: Boolean? = null,

	@Json(name="message")
	val message: String? = null,
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class ArticlesItem(

	@Json(name="thumbnail")
	val thumbnail: String? = null,

	@Json(name="link")
	val link: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="pubDate")
	val pubDate: String? = null
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Data(

	@Json(name="image")
	val image: String? = null,

	@Json(name="link")
	val link: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="posts")
	val posts: List<ArticlesItem>,
) : Parcelable
