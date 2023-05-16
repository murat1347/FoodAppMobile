package com.tilkiweb.foodrecipes.models

import com.google.gson.annotations.SerializedName

data class Category( @SerializedName("id"         ) var id         : String? = null,
                     @SerializedName("defination" ) var defination : String? = null,
                     @SerializedName("imageUrl"   ) var imageUrl   : String? = null,
                     @SerializedName("parentId"   ) var parentId   : String? = null
)
