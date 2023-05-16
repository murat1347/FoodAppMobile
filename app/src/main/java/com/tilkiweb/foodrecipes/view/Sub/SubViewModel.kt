package com.tilkiweb.foodrecipes.view.Sub

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilkiweb.foodrecipes.models.ApiError
import com.tilkiweb.foodrecipes.models.IViewModelState
import com.tilkiweb.foodrecipes.models.res.SubCategoryResponse
import com.tilkiweb.foodrecipes.services.DetailService
import kotlinx.coroutines.launch

class SubViewModel: ViewModel(), IViewModelState {
    override var errorState: MutableLiveData<ApiError> = MutableLiveData<ApiError>()
    val categories = MutableLiveData<SubCategoryResponse?>()

    suspend fun getcategories(id : String?){
        viewModelScope.launch {
            val response = DetailService.getCategories(id!!)

            if (response.isSuccessful) {
                categories.value = response.success
            } else {
                errorState.value = response.fail!!
            }

        }
    }
}