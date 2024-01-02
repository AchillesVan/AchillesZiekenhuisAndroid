package com.example.achillesziekenhuis

import android.app.Application
import com.example.achillesziekenhuis.data.AppContainer
import com.example.achillesziekenhuis.data.DefaultAppContainer

/**
 * Main application class.
 */
class DoktersApplication : Application() {
    /**
     * App container.
     */
    lateinit var container: AppContainer

    /**
     * Create the app container when the application is created.
     */
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(context = applicationContext)
    }
}
