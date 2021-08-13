package com.example.daggerdemo

import android.app.Application
import com.example.daggerdemo.di.AppComponent
import com.example.daggerdemo.di.DaggerAppComponent
import com.example.daggerdemo.storage.SharedPreferencesStorage
import com.example.daggerdemo.user.UserManager

open class MyApplication : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext)
    }
}