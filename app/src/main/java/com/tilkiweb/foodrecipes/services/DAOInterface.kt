package com.tilkiweb.foodrecipes.services

import com.tilkiweb.foodrecipes.models.ApiResponse
import com.tilkiweb.foodrecipes.models.req.CategoryReq
import com.tilkiweb.foodrecipes.models.res.*

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface DAOInterface {
    @GET("Category")
    suspend fun getCategories(): Response<CategoryResponse>

    @GET("Category/{id}")
    suspend fun getCategoryById(@Path("id") id: String): Response<SubCategoryResponse>

    @GET("Category/GetFoodsByCategory/{id}")
    suspend fun getFoodsList(@Path("id") id: String): Response<FoodsResponse>
    @GET("Foods/{id}")
    suspend fun getFoods(@Path("id") id: String): Response<FoodDetailResponse>
}
