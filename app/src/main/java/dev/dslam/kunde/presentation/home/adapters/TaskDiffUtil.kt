package dev.dslam.kunde.presentation.home.adapters

import androidx.recyclerview.widget.DiffUtil
import dev.dslam.kunde.model.entities.Task

class TaskDiffUtil: DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}