package com.example.homework2_android2.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.homework2_android2.ui.db.AppDataBase
import com.example.homework2_android2.utils.PreferenceHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        getInstance()
        val preferenceHelpers = PreferenceHelper()
        preferenceHelpers.unit(this)
    }

    companion object {

        private var appDatabase: AppDataBase? = null
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        fun getInstance(): AppDataBase? {
            if (appDatabase == null) {
                appDatabase = context?.let {
                    Room.databaseBuilder(
                        it,
                        AppDataBase::class.java,
                        "note.database"
                    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }
}