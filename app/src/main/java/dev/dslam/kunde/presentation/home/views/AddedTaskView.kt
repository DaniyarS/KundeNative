package dev.dslam.kunde.presentation.home.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import dev.dslam.kunde.databinding.AddedTaskViewBinding
import dev.dslam.kunde.model.entities.Task
import dev.dslam.kunde.utils.DateFormats
import java.text.SimpleDateFormat
import java.util.Locale

class AddedTaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private val binding = AddedTaskViewBinding.inflate(LayoutInflater.from(context), this, true)

    fun configure(task: Task) {
        val dateFormat = SimpleDateFormat(DateFormats.DD_MM_YYYY, Locale.getDefault())
        val formattedDate = dateFormat.format(task.deadline)

        with(binding) {
            taskName.text = task.name
            taskDescription.text = task.description
            deadlineDate.text = formattedDate


        }
    }
}