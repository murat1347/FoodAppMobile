package com.tilkiweb.foodrecipes.models.res

import com.google.gson.annotations.SerializedName

data class FoodImageFiles (

  @SerializedName("images"      ) var images      : ArrayList<Images> = arrayListOf(),
  @SerializedName("id"          ) var id          : String?           = null,
  @SerializedName("createdDate" ) var createdDate : String?           = null,
  @SerializedName("updatedDate" ) var updatedDate : String?           = null

)