package dev.dslam.kunde.presentation.task

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.dslam.kunde.R
import dev.dslam.kunde.databinding.ActivityAddTaskBinding
import dev.dslam.kunde.presentation.task.viewModels.AddTaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddTaskActivity : AppCompatActivity() {

    private var _binding: ActivityAddTaskBinding? = null
    private val binding: ActivityAddTaskBinding
        get() = _binding!!

    private val viewModel: AddTaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        configureObservers()
    }

    private fun setupViews() {
        with(binding.addTaskView) {
            configure()
            addPressed = { newTask ->
                viewModel.addTask(newTask)
            }
        }
    }

    private fun configureObservers() {
        viewModel.state.observe(this) { isAdded ->
            if (isAdded) {
                Toast.makeText(this, R.string.successfully_added, Toast.LENGTH_SHORT).show()
                this.finish()
            }
        }
    }
}