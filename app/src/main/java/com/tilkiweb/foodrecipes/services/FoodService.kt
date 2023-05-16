package com.tilkiweb.foodrecipes.services

import com.tilkiweb.foodrecipes.models.ApiResponse
import com.tilkiweb.foodrecipes.models.res.Food
import com.tilkiweb.foodrecipes.models.res.FoodsResponse
import com.tilkiweb.foodrecipes.models.res.SubCategoryResponse
import com.tilkiweb.foodrecipes.utils.HelperService
import com.tilkiweb.foodrecipes.utils.RetrofitClient

class FoodService {
    companion object {
        val retrofit = RetrofitClient.getClient()!!
        val reqServices: DAOInterface = retrofit!!.create(DAOInterface::class.java)
//        suspend fun getFoods(id : String): ApiResponse<Food> {
//            try {
//
//
//                val res = reqServices.getFoods(id)
//
//                if (!res.isSuccessful) return HelperService.handleApiError(res)
//                var body = res.body()
//
//                return ApiResponse(true, body, null)
//            } catch (ex: Exception) {
//                return HelperService.handleException(ex)
//            }
//        }

        suspend fun getFoodsList(id : String): ApiResponse<FoodsResponse> {
            try {


                val res = reqServices.getFoodsList(id)

                if (!res.isSuccessful) return HelperService.handleApiError(res)
                var body = res.body()

                return ApiResponse(true, body, null)
            } catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
        }
    }
}