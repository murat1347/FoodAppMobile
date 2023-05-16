package com.tilkiweb.foodrecipes.models.res

import com.google.gson.annotations.SerializedName

data class FoodsResponse(@SerializedName("foods" ) var foods : ArrayList<Food> = arrayListOf())
