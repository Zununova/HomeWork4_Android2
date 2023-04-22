package com.example.homework2_android2.ui.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework2_android2.ui.db.daos.NoteDoa
import com.example.homework2_android2.ui.models.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDoa
}