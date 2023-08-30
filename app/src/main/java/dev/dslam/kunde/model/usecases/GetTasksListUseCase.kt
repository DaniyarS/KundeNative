package dev.dslam.kunde.model.usecases

import dev.dslam.kunde.model.repositories.TaskRepository

class GetTasksListUseCase (private val taskRepository: TaskRepository) {
    suspend operator fun invoke() = taskRepository.getTasks()
}