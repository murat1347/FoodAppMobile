package com.tilkiweb.foodrecipes.view.food

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilkiweb.foodrecipes.models.ApiError
import com.tilkiweb.foodrecipes.models.IViewModelState
import com.tilkiweb.foodrecipes.models.res.FoodsResponse
import com.tilkiweb.foodrecipes.models.res.SubCategoryResponse
import com.tilkiweb.foodrecipes.services.DetailService
import com.tilkiweb.foodrecipes.services.FoodService
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel(), IViewModelState {
    override var errorState: MutableLiveData<ApiError> = MutableLiveData<ApiError>()
        val foods = MutableLiveData<FoodsResponse?>()

    suspend fun getfoods(id : String?){
        viewModelScope.launch {
            val response = FoodService.getFoodsList(id!!)

            if (response.isSuccessful) {
                foods.value = response.success
            } else {
                errorState.value = response.fail!!
            }

        }
    }
}