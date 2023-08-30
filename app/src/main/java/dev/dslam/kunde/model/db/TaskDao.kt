package dev.dslam.kunde.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.dslam.kunde.model.entities.Task

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task)

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<Task>
}