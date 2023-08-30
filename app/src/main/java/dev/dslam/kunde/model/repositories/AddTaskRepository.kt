package dev.dslam.kunde.model.repositories

import dev.dslam.kunde.model.entities.Task

interface AddTaskRepository {
    suspend fun addTask(task: Task)
}