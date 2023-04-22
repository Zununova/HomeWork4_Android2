package com.example.homework2_android2.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework2_android2.R
import com.example.homework2_android2.databinding.FragmentHomeBinding
import com.example.homework2_android2.ui.App
import com.example.homework2_android2.ui.adapters.DetailAdapter
import com.example.homework2_android2.utils.PreferenceHelper

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val noteAdapter = DetailAdapter()
    private var counterNumber = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListener()
        setData()
    }

    private fun initialize() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(requireContext())
        val bool = preferenceHelper.saveBoolean

        if (bool == false) {
            val navController = findNavController()
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
            navGraph.setStartDestination(R.id.onBoardFragment)
            navController.graph = navGraph
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun setUpListener() {
        binding.buttonOnClick.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_writingFragment)
        }

        binding.changer.setOnClickListener {
            if (counterNumber == 1) {
                binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.changer.setImageResource(R.drawable.lines)
                counterNumber--
            } else {
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                binding.changer.setImageResource(R.drawable.type)
                counterNumber++
            }
        }
    }

    private fun setData() {
        App.getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            noteAdapter.setNoteList(it)
        }
    }
}