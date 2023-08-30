package dev.dslam.kunde.di

import dev.dslam.kunde.model.repositories.TaskRepositoryImpl
import dev.dslam.kunde.model.usecases.AddTaskUseCase
import dev.dslam.kunde.model.usecases.GetTasksListUseCase
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        TaskRepositoryImpl(
            taskDao = get()
        )
    }

    factory {
        AddTaskUseCase(
            taskRepository = get<TaskRepositoryImpl>()
        )
    }

    factory {
        GetTasksListUseCase(
            taskRepository = get<TaskRepositoryImpl>()
        )
    }
}