package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AppUiState(
    val inputText: String = "",
    val counter: Int = 0,
    val isButtonEnabled: Boolean = false
)

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())

    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    fun onTextChanged(newText: String) {
        _uiState.value = _uiState.value.copy(
            inputText = newText,
            isButtonEnabled = newText.isNotBlank()
        )
    }

    fun incrementCounter() {
        _uiState.value = _uiState.value.copy(
            counter = _uiState.value.counter + 1
        )
    }
}