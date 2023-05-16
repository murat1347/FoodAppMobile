package com.tilkiweb.foodrecipes.models.res

import com.google.gson.annotations.SerializedName

data class Food(  @SerializedName("title"            ) var title            : String?         = null,
                  @SerializedName("foodImageFilesId" ) var foodImageFilesId : String?         = null,
                  @SerializedName("foodImageFiles"   ) var foodImageFiles   : FoodImageFiles? =  null,
                  @SerializedName("description"      ) var description      : String?         = null,
                  @SerializedName("categoryId"       ) var categoryId       : String?         = null,
                  @SerializedName("id"               ) var id               : String?         = null,
                  @SerializedName("createdDate"      ) var createdDate      : String?         = null,
                  @SerializedName("updatedDate"      ) var updatedDate      : String?         = null)
