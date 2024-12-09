package com.ucb.eldroid.removalproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ucb.eldroid.removalproject.models.MenuItem
import com.ucb.eldroid.removalproject.utils.MenuRepository

class MenuViewModel : ViewModel() {
    private val repository = MenuRepository()
    val menuItems = MutableLiveData<List<MenuItem>>()

    fun addItem(item: MenuItem) {
        repository.addItem(item) {
            fetchMenuItems()
        }
    }

    fun editItem(itemId: String, updatedItem: MenuItem) {
        repository.editItem(itemId, updatedItem) {
            fetchMenuItems()
        }
    }

    fun deleteItem(itemId: String) {
        repository.deleteItem(itemId) {
            fetchMenuItems()
        }
    }

    fun fetchMenuItems() {
        repository.getMenuItems { items ->
            menuItems.value = items
        }
    }
}
