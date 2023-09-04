package dev.dslam.kunde.presentation.home.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import dev.dslam.kunde.databinding.FragmentHomeBinding
import dev.dslam.kunde.presentation.base.BaseFragment
import dev.dslam.kunde.presentation.home.adapters.HomePageContentListAdapter
import dev.dslam.kunde.presentation.home.viewModels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModel()
    private val contentListAdapter: HomePageContentListAdapter by lazy {
        HomePageContentListAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.contentList.adapter = contentListAdapter
        configureObservers()
        viewModel.getTasks()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTasks()
    }

    private fun configureObservers() {
        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            with(binding) {
                if (tasks.isEmpty()) {
                    noTaskAddedLabel.root.isVisible = true
                    contentList.isVisible = false
                } else {
                    contentListAdapter.submitList(tasks)
                }
            }
        }
    }
}