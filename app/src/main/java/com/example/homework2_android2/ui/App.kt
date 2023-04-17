package com.example.homework2_android2.ui

import android.app.Application
import com.example.homework2_android2.utils.PreferenceHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val preferenceHelpers = PreferenceHelper()
        preferenceHelpers.unit(this)
    }
}