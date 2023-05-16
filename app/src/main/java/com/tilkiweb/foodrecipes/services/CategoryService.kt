package com.tilkiweb.foodrecipes.services

import com.tilkiweb.foodrecipes.models.ApiResponse
import com.tilkiweb.foodrecipes.models.res.CategoryResponse
import com.tilkiweb.foodrecipes.utils.HelperService
import com.tilkiweb.foodrecipes.utils.RetrofitClient

class CategoryService {
    companion object {
        val retrofit = RetrofitClient.getClient()!!
        val reqServices: DAOInterface = retrofit!!.create(DAOInterface::class.java)
        suspend fun getCategories(): ApiResponse<CategoryResponse> {
            try {

                val res = reqServices.getCategories()

                if (!res.isSuccessful) return HelperService.handleApiError(res)
                var body = res.body()

                return ApiResponse(true, body, null)
            } catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
        }
    }
}