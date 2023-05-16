package com.tilkiweb.foodrecipes.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class GlobalApp:Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
         lateinit var mContext: Context

            public fun getAppContext(): Context {

                return mContext
            }


    }


    override fun onCreate() {
        super.onCreate()
        mContext = this;
    }

}