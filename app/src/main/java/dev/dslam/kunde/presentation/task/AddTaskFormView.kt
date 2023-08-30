package dev.dslam.kunde.presentation.task

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import androidx.cardview.widget.CardView
import dev.dslam.kunde.databinding.AddTaskViewBinding
import dev.dslam.kunde.model.entities.Task
import dev.dslam.kunde.utils.DateFormats
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class AddTaskFormView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    var addPressed: ((Task) -> Unit)? = null

    private val binding = AddTaskViewBinding.inflate(LayoutInflater.from(context), this, true)
    private val calendar = Calendar.getInstance()
    private var deadlineDate: Date? = null

    @SuppressLint("ClickableViewAccessibility")
    fun configure() {
        with(binding) {

            taskDeadlineEt.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    showDatePickerDialog()
                }
                true
            }

            taskDeadlineEt.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    showDatePickerDialog()
                }
            }

            addTaskButton.setOnClickListener {
                addPressed?.invoke(
                    Task(
                        name = taskNameEt.text.toString(),
                        deadline = deadlineDate ?: Date(),
                        description = taskDescriptionEt.text.toString()
                    )
                )
            }
        }
    }

    private fun showDatePickerDialog() {
        val today = Calendar.getInstance()

        DatePickerDialog(
            context,
            { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)

                val dateFormat = SimpleDateFormat(DateFormats.DD_MM_YYYY, Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                deadlineDate = selectedDate.time
                binding.taskDeadlineEt.setText(formattedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).apply {
            datePicker.minDate = today.timeInMillis
        }.also {
            it.show()
        }
    }
}