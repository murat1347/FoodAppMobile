package com.tilkiweb.foodrecipes.services

import com.tilkiweb.foodrecipes.models.ApiResponse
import com.tilkiweb.foodrecipes.models.req.CategoryReq
import com.tilkiweb.foodrecipes.models.res.*
import com.tilkiweb.foodrecipes.utils.HelperService
import com.tilkiweb.foodrecipes.utils.RetrofitClient

class DetailService {

    companion object {
        val retrofit = RetrofitClient.getClient()!!
        val reqServices: DAOInterface = retrofit!!.create(DAOInterface::class.java)
        suspend fun getCategories(id : String): ApiResponse<SubCategoryResponse> {
            try {


                val res = reqServices.getCategoryById(id)

                if (!res.isSuccessful) return HelperService.handleApiError(res)
                var body = res.body()

                return ApiResponse(true, body, null)
            } catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
        }
        suspend fun getFood(id : String): ApiResponse<FoodDetailResponse> {
            try {
                val res = reqServices.getFoods(id)

                if (!res.isSuccessful) return HelperService.handleApiError(res)
                var body = res.body()

                return ApiResponse(true, body, null)
            }catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
    }
}
}