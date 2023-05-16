package com.tilkiweb.foodrecipes.view.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilkiweb.foodrecipes.models.ApiError
import com.tilkiweb.foodrecipes.models.IViewModelState
import com.tilkiweb.foodrecipes.models.res.*
import com.tilkiweb.foodrecipes.services.CategoryService
import com.tilkiweb.foodrecipes.services.DetailService
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel(), IViewModelState {
    override var errorState: MutableLiveData<ApiError> = MutableLiveData<ApiError>()
    val categories = MutableLiveData<FoodDetailResponse?>()

    suspend fun getfood(id : String?){
        viewModelScope.launch {
            val response = DetailService.getFood(id!!)

            if (response.isSuccessful) {
                categories.value = response.success
            } else {
                errorState.value = response.fail!!
            }

        }
    }
}