package dev.dslam.kunde.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    val deadline: Date,
    val taskStatus: TaskStatus = TaskStatus.ADDED
)