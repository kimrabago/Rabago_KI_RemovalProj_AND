package com.ucb.eldroid.removalproject.api

import com.ucb.eldroid.removalproject.models.MenuItem
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("/api/menu-items")
    fun getMenuItems(): Call<List<MenuItem>>

    @POST("/api/menu-items")
    fun addItem(@Body item: MenuItem): Call<Void>

    @PUT("/api/menu-items/{id}")
    fun editItem(@Path("id") id: String, @Body item: MenuItem): Call<Void>

    @DELETE("/api/menu-items/{id}")
    fun deleteItem(@Path("id") id: String): Call<Void>
}