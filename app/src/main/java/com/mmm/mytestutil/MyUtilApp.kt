package com.mmm.mytestutil

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDexApplication

class MyUtilApp :MultiDexApplication(){

    companion object {
        val instance get() =  MyUtilApp()
        fun getContext(): Context? {
            return instance.applicationContext
        }

    }
    override fun onCreate() {
        super.onCreate()
    }

}