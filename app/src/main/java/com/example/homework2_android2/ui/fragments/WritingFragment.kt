package com.example.homework2_android2.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework2_android2.databinding.FragmentWritingBinding
import com.example.homework2_android2.ui.App
import com.example.homework2_android2.ui.models.ItemModel
import java.util.*

class WritingFragment : Fragment() {

    private lateinit var binding: FragmentWritingBinding
    private val calendar = Calendar.getInstance()
    private val timeString =
        "${calendar.get(Calendar.HOUR_OF_DAY)}:${calendar.get(Calendar.MINUTE)}"
    private val dateString =
        "${calendar.get(Calendar.DAY_OF_MONTH)}.${calendar.get(Calendar.MONTH) + 1}.${
            calendar.get(Calendar.YEAR)
        }"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentWritingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
        setTime()
    }

    private fun setUpListener() = with(binding) {
        imageViewOnClick.setOnClickListener {
            val text = inputText.text.toString()
            App.getInstance()?.noteDao()?.insert(
                ItemModel(text, data = dateString, time = timeString)
            )
            findNavController().navigateUp()
        }
    }

    private fun setTime() {
        binding.textViewTime.text = timeString
        binding.textViewData.text = dateString

    }
}