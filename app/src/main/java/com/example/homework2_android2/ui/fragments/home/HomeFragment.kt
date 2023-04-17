package com.example.homework2_android2.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.homework2_android2.R
import com.example.homework2_android2.databinding.FragmentHomeBinding
import com.example.homework2_android2.utils.PreferenceHelper

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(requireContext())
        preferenceHelper.saveBoolean = true
    }
}