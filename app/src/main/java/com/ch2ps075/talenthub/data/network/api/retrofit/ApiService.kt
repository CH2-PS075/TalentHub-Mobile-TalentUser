package com.ch2ps075.talenthub.data.network.api.retrofit

import com.ch2ps075.talenthub.data.network.api.response.AuthResponse
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("auth/talents/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): AuthResponse

    @FormUrlEncoded
    @POST("talents")
    suspend fun registertalent(
        @Field("talentName") talentName: String,
        @Field("quantity") quantity: String,
        @Field("address") address: String,
        @Field("category") category: String,
        @Field("contact") contact: String,
        @Field("price") price: String,
        @Field("picture") picture: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): AuthResponse
}