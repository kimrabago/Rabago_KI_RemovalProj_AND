package com.ucb.eldroid.removalproject.utils

import com.ucb.eldroid.removalproject.api.ApiService
import com.ucb.eldroid.removalproject.models.MenuItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuRepository {

    private val api = RetrofitClient.apiService

    fun getMenuItems(callback: (List<MenuItem>) -> Unit) {
        api.getMenuItems().enqueue(object : Callback<List<MenuItem>> {
            override fun onResponse(call: Call<List<MenuItem>>, response: Response<List<MenuItem>>) {
                if (response.isSuccessful) {
                    callback(response.body() ?: emptyList())
                } else {
                    callback(emptyList())
                }
            }

            override fun onFailure(call: Call<List<MenuItem>>, t: Throwable) {
                callback(emptyList())
            }
        })
    }

    // Add item function
    fun addItem(item: MenuItem, callback: () -> Unit) {
        api.addItem(item).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                callback()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                callback()
            }
        })
    }

    fun editItem(itemId: String, updatedItem: MenuItem, callback: () -> Unit) {
        api.editItem(itemId, updatedItem).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                callback()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                callback()
            }
        })
    }

    fun deleteItem(itemId: String, callback: () -> Unit) {
        api.deleteItem(itemId).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                callback()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                callback()
            }
        })
    }
}
