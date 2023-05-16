package com.tilkiweb.foodrecipes.view.main

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilkiweb.foodrecipes.models.ApiError
import com.tilkiweb.foodrecipes.models.ApiResponse
import com.tilkiweb.foodrecipes.models.IViewModelState
import com.tilkiweb.foodrecipes.models.res.CategoryResponse
import com.tilkiweb.foodrecipes.services.CategoryService
import kotlinx.coroutines.launch

class MainViewModel :  ViewModel(), IViewModelState {
    override var errorState: MutableLiveData<ApiError> = MutableLiveData<ApiError>()
    val categories = MutableLiveData<CategoryResponse>()
    @SuppressLint("NullSafeMutableLiveData")
    suspend fun getCategories() {

        viewModelScope.launch {
            val response = CategoryService.getCategories()

            if (response.isSuccessful) {
                categories.value = response.success
            } else {
                errorState.value = response.fail!!
            }

        }
    }
}