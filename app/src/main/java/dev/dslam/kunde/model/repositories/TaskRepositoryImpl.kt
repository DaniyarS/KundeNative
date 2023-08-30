package dev.dslam.kunde.model.repositories

import dev.dslam.kunde.model.db.TaskDao
import dev.dslam.kunde.model.entities.Task

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {
    override suspend fun addTask(task: Task) {
        taskDao.insertTask(task)
    }

    override suspend fun getTasks(): List<Task> {
        return taskDao.getAllTasks()
    }
}