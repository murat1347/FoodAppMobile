package com.tilkiweb.foodrecipes.models.res

import com.google.gson.annotations.SerializedName

data class FoodDetailResponse (@SerializedName("title"          ) var title          : String?         = null,
                               @SerializedName("description"    ) var description    : String?         = null,
                               @SerializedName("foodImageFiles" ) var foodImageFiles : FoodImageFiles? = FoodImageFiles())