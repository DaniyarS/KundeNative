package dev.dslam.kunde.di

import dev.dslam.kunde.presentation.home.viewModels.HomeViewModel
import dev.dslam.kunde.presentation.addTask.viewModels.AddTaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AddTaskViewModel(
            addTaskUseCase = get()
        )
    }

    viewModel {
        HomeViewModel(
            getTasksListUseCase = get()
        )
    }
}