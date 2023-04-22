package com.example.homework2_android2.ui.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemModel")
data class ItemModel(
    var noteText: String? = null,
    var data: String? = null,
    var time: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}