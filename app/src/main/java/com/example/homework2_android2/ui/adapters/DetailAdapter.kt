package com.example.homework2_android2.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2_android2.databinding.ItemBinding
import com.example.homework2_android2.ui.models.ItemModel

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private var noteList: List<ItemModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setNoteList(list: List<ItemModel>) {
        noteList = list
        notifyDataSetChanged()
    }

    inner class DetailViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(itemModel: ItemModel) {
            binding.textViewNote.text = itemModel.noteText
            binding.textViewData.text = itemModel.data
            binding.time.text = itemModel.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.onBind(noteList[position])
    }
}