package com.example.homework2_android2.utils

import android.content.Context
import android.content.SharedPreferences
class PreferenceHelper {

    private var sharedPreferences: SharedPreferences? = null

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    var saveBoolean
        set(value) = sharedPreferences?.edit()?.putBoolean("Bool", value!!)?.apply()!!
        get() = sharedPreferences?.getBoolean("Bool", false)
}