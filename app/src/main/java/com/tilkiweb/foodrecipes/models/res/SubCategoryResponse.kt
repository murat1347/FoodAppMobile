package com.tilkiweb.foodrecipes.models.res

import com.google.gson.annotations.SerializedName
import com.tilkiweb.foodrecipes.models.Category

data class SubCategoryResponse (  @SerializedName("categories"   ) var categories   : ArrayList<Category> = arrayListOf())