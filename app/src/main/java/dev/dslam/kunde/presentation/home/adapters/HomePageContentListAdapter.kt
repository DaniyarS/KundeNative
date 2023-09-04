package dev.dslam.kunde.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.kunde.databinding.AddedTaskListItemBinding
import dev.dslam.kunde.model.entities.Task

class HomePageContentListAdapter : ListAdapter<Task, HomePageContentListAdapter.ContentListViewHolder>(TaskDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentListViewHolder {
        return ContentListViewHolder(
            AddedTaskListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContentListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ContentListViewHolder(private val binding: AddedTaskListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.addedTaskView.configure(task)
        }
    }
}