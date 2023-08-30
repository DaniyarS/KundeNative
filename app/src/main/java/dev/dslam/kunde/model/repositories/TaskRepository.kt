package dev.dslam.kunde.model.repositories

import dev.dslam.kunde.model.entities.Task

interface TaskRepository {
    suspend fun addTask(task: Task)

    suspend fun getTasks(): List<Task>
}