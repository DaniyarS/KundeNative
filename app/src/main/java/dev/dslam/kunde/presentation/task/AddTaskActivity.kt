package dev.dslam.kunde.presentation.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.dslam.kunde.databinding.ActivityAddTaskBinding

@AndroidEntryPoint
class AddTaskActivity : AppCompatActivity() {

    private var _binding: ActivityAddTaskBinding? = null
    private val binding: ActivityAddTaskBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        with(binding.addTaskView) {
            configure()
            addPressed = { newTask ->

            }
        }
    }
}