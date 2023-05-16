package com.tilkiweb.foodrecipes.utils

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.HashSet
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
        fun getClient(): Retrofit? {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder().addNetworkInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(NetworkInterceptor())
                .build()
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl(ApiUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
            return retrofit
        }

        class ReceivedCookiesInterceptor : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val originalResponse: Response = chain.proceed(chain.request())
                if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
                    val cookies: HashSet<String> = HashSet()
                    for (header in originalResponse.headers("Set-Cookie")) {
                        cookies.add(header)
                    }

                    val preference = GlobalApp.getAppContext()
                        .getSharedPreferences("APIToken", Context.MODE_PRIVATE)
                    var editor = preference.edit()
                    editor.putStringSet("PREF_COOKIES", cookies)
                    editor.apply()
                }
                return originalResponse
            }
        }
    }
}