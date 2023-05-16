package com.tilkiweb.foodrecipes.models

import androidx.lifecycle.MutableLiveData

interface IViewModelState {

    var errorState:MutableLiveData<ApiError>
}