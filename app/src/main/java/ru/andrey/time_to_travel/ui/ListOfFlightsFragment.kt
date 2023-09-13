package ru.andrey.time_to_travel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ru.andrey.time_to_travel.R
import ru.andrey.time_to_travel.adapter.FlightsAdapter
import ru.andrey.time_to_travel.databinding.ListOfFlightsFragmentBinding
import ru.andrey.time_to_travel.model.ListState
import ru.andrey.time_to_travel.viewmodel.AirTravelViewModel

@AndroidEntryPoint
class ListOfFlightsFragment : Fragment() {
    private lateinit var binding: ListOfFlightsFragmentBinding
    private lateinit var adapter: FlightsAdapter
    private val viewModel: AirTravelViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ListOfFlightsFragmentBinding.inflate(layoutInflater)
        adapter = FlightsAdapter {
            findNavController().navigate(
                R.id.action_listOfFlightsFragment_to_airTravelDetails3,
                bundleOf("searchTokenArg" to it.searchToken)
            )
        }
        binding.list.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.dataState.collectLatest { state ->
                when (state) {
                    is ListState.Loading -> {
                        binding.list.isVisible = false
                        binding.progressBar.isVisible = true
                        binding.errorGroup.isVisible = false
                    }

                    is ListState.Idle -> {
                        binding.list.isVisible = true
                        binding.progressBar.isVisible = false
                        binding.errorGroup.isVisible = false
                    }

                    is ListState.Error -> {
                        binding.list.isVisible = false
                        binding.progressBar.isVisible = false
                        binding.errorGroup.isVisible = true
                    }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.data.collectLatest {
                adapter.submitList(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            binding.reload.setOnClickListener {
                viewModel.loadFlights()
            }
        }

        return binding.root
    }
}