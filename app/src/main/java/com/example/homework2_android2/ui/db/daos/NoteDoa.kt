package com.example.homework2_android2.ui.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework2_android2.ui.models.ItemModel

@Dao
interface NoteDoa {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(itemModel: ItemModel)

    @Query("SELECT * FROM itemModel")
    fun getAll(): LiveData<List<ItemModel>>
}