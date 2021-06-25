package com.bigodecompany.whatdidilearn.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigodecompany.whatdidilearn.data.LearnedItemRepository
import com.bigodecompany.whatdidilearn.entities.LearnedItem
import kotlinx.coroutines.launch

class NewItemViewModel(private val repository: LearnedItemRepository) : ViewModel() {
    val showError = MutableLiveData<Boolean>()

    fun insert(item: LearnedItem) = viewModelScope.launch {
        repository.insert(item)
    }

    fun insertForm(item: LearnedItem) {
//        if (validateForm(item)) {
        insert(item)
//        }
    }

//    private fun validateForm(item: LearnedItem): Boolean {
//        showError.value = false
//        if (item.name.isBlank() || item.description.isBlank() || item.understandingLevel.name.isEmpty()) {
//            showError.value = true
//            return true
//        }
//        return false
//    }
}