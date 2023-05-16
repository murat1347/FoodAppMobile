package com.tilkiweb.foodrecipes.models.res

import com.google.gson.annotations.SerializedName
import com.tilkiweb.foodrecipes.models.Category

data class CategoryResponse(
    @SerializedName("totalCount" ) var totalCount : Int?                = null,
    @SerializedName("category"   ) var category   : ArrayList<Category> = arrayListOf())