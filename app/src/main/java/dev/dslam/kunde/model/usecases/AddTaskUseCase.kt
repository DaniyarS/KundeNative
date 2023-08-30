package dev.dslam.kunde.model.usecases

import dev.dslam.kunde.model.entities.Task
import dev.dslam.kunde.model.repositories.TaskRepository

class AddTaskUseCase (private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task) = taskRepository.addTask(task)
}