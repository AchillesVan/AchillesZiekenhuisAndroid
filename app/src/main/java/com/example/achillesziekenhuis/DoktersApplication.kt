package com.example.achillesziekenhuis

import android.app.Application
import com.example.achillesziekenhuis.data.AppContainer
import com.example.achillesziekenhuis.data.DefaultAppContainer

class DoktersApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(context = applicationContext)
    }
}
