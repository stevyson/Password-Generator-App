package com.stevyson.passwordmanager1.presentation.password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevyson.passwordmanager1.domain.model.Password
import com.stevyson.passwordmanager1.domain.repository.PasswordRepository
import com.stevyson.passwordmanager1.presentation.password.add_screen.AddScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class PasswordState(
    var passwords: List<Password> = emptyList()
)

@HiltViewModel
class PasswordViewModel @Inject constructor(
    private val repository: PasswordRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PasswordState())
    val uiState: StateFlow<PasswordState> = _uiState.asStateFlow()


    init {
        loadPassword()
    }


    fun loadPassword(){
        repository.getPasswords().onEach { passwords ->
            _uiState.value = uiState.value.copy(
                passwords = passwords
            )
        }
            .launchIn(viewModelScope)
    }

    fun deletePassword(password: Password){
        viewModelScope.launch {
            repository.deletePassword(password)
        }
    }






}