package dev.dslam.kunde.model.entities

import java.util.*

data class Task(
    val id: Int = 0,
    val name: String,
    val description: String,
    val deadline: Date,
    val taskStatus: TaskStatus = TaskStatus.ADDED
)