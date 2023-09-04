package dev.dslam.kunde.presentation.addTask.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.dslam.kunde.model.entities.Task
import dev.dslam.kunde.model.usecases.AddTaskUseCase
import dev.dslam.kunde.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AddTaskViewModel(
    private val addTaskUseCase: AddTaskUseCase
) : BaseViewModel() {

    private val _state = MutableLiveData<Boolean>()
    val state: LiveData<Boolean> = _state

    fun addTask(task: Task) {
        launch(Dispatchers.IO) {
            try {
                addTaskUseCase.invoke(task)
                _state.postValue(true)
            } catch (_: Exception) {
                _state.postValue(false)
            }
        }
    }
}