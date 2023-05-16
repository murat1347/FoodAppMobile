package com.tilkiweb.foodrecipes.utils

import android.content.Context
import android.widget.Toast
import com.google.gson.Gson
import com.tilkiweb.foodrecipes.R
import com.tilkiweb.foodrecipes.models.ApiError
import com.tilkiweb.foodrecipes.models.ApiResponse
import retrofit2.Response

class HelperService {
    companion object {

        fun <T> handleException(ex: Exception): ApiResponse<T> {
            return when (ex) {

                is OfflineException -> {

                    val exmessage =
                        arrayListOf(GlobalApp.getAppContext().resources.getString(R.string.ex_no_exception))
                    Toast.makeText(GlobalApp.getAppContext(),exmessage.toString(), Toast.LENGTH_LONG).show()

                    val array = arrayListOf<String>(exmessage.toString())

                    val apiError=  ApiError(array,false)
                    ApiResponse(false, fail = apiError)


                }


                else -> {
                    val exmessage =
                        arrayListOf(GlobalApp.getAppContext().resources.getString(R.string.ex_common_error))
                    var apiError =  ApiError(exmessage,false)
                    ApiResponse(false, fail = apiError)


                }


            }


        }








        fun <T1, T2> handleApiError(response: Response<T1>): ApiResponse<T2> {
            var apiError: ApiError? = null;

            if (response.errorBody() != null) {
                var errorBody = response.errorBody()!!.string()

                apiError = Gson().fromJson(errorBody, ApiError::class.java)
            }


            return ApiResponse(false, null, apiError)
        }

        fun showErrorMessageByToast(apiError: ApiError?) {

            if (apiError == null) return
            var errorBuilder = StringBuilder()

            if (!apiError.Status) {
                for (error in apiError.Errors) {
                    errorBuilder.append(error + "\n")
                }

            }

            Toast.makeText(GlobalApp.getAppContext(), errorBuilder.toString(), Toast.LENGTH_LONG)
                .show()


        }

    }
}