package com.ucb.eldroid.removalproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ucb.eldroid.removalproject.models.MenuItem
import com.ucb.eldroid.removalproject.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuViewModel : ViewModel() {

    private val api = RetrofitClient.apiService
    val menuItems = MutableLiveData<List<MenuItem>>()

    fun fetchMenuItems() {
        api.getMenuItems().enqueue(object : Callback<List<MenuItem>> {
            override fun onResponse(call: Call<List<MenuItem>>, response: Response<List<MenuItem>>) {
                if (response.isSuccessful) {
                    menuItems.value = response.body() ?: emptyList()
                } else {
                    menuItems.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<MenuItem>>, t: Throwable) {
                menuItems.value = emptyList()
            }
        })
    }

    fun addItem(item: MenuItem) {
        api.addItem(item).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                fetchMenuItems()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                fetchMenuItems()
            }
        })
    }

    fun editItem(itemId: String, updatedItem: MenuItem) {
        api.editItem(itemId, updatedItem).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                fetchMenuItems()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                fetchMenuItems()
            }
        })
    }

    fun deleteItem(itemId: String) {
        api.deleteItem(itemId).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                fetchMenuItems()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                fetchMenuItems()
            }
        })
    }
}
