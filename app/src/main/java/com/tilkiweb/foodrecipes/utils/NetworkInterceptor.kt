package com.tilkiweb.foodrecipes.utils

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        if(!LiveNetworkListener.isConnected())
        {
            throw OfflineException("")

        }

        var request= chain.request()

        return chain.proceed(request)



    }
}

