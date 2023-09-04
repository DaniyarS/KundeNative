package dev.dslam.kunde.presentation.home.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.dslam.kunde.model.entities.Task
import dev.dslam.kunde.model.usecases.GetTasksListUseCase
import dev.dslam.kunde.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val getTasksListUseCase: GetTasksListUseCase): BaseViewModel() {

    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> = _tasks

    fun getTasks() {
        launch(Dispatchers.IO) {
            _tasks.postValue(getTasksListUseCase.invoke())
        }
    }
}