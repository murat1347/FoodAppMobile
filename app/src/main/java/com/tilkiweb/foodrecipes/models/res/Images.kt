package com.tilkiweb.foodrecipes.models.res

import com.google.gson.annotations.SerializedName

data class Images(@SerializedName("imageUrl"    ) var imageUrl    : String? = null,
                  @SerializedName("id"          ) var id          : String? = null,
                  @SerializedName("createdDate" ) var createdDate : String? = null,
                  @SerializedName("updatedDate" ) var updatedDate : String? = null
)
