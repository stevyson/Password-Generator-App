package com.stevyson.passwordmanager1.presentation.password

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevyson.passwordmanager1.domain.model.Category
import com.stevyson.passwordmanager1.domain.model.InvalidPasswordException
import com.stevyson.passwordmanager1.domain.model.Password
import com.stevyson.passwordmanager1.domain.repository.PasswordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AddScreenState(
  var siteName: String = "",
  var email: String = "",
  var password: String = "",
  var category: Category = Category.Social,

  )


@HiltViewModel
class AddViewModel @Inject constructor(
  private val repository: PasswordRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {
  private val _uiState = MutableStateFlow(AddScreenState())
  val uiState: StateFlow<AddScreenState> = _uiState.asStateFlow()

  private val _eventFlow = MutableSharedFlow<UiEvent>()
  val eventFlow = _eventFlow.asSharedFlow()

  private var currentPasswordId: Int? = null

  init {
    savedStateHandle.get<Int>("passwordId")?.let { passwordId ->
      if(passwordId != -1) {
        viewModelScope.launch {
          repository.getPasswordById(passwordId)?.also { password ->
            currentPasswordId = password.id
            _uiState.value.siteName = uiState.value.siteName
            _uiState.value.email = uiState.value.email
            _uiState.value.password = uiState.value.password
            _uiState.value.category = uiState.value.category
          }
        }
      }
    }
  }



  fun setSiteName(siteName: String) {
    _uiState.update { currentState ->
      currentState.copy(
        siteName = siteName
      )
    }
  }

  fun setEmail(email: String) {
    _uiState.update { currentState ->
      currentState.copy(
        email = email
      )
    }
  }

  fun setPassword(password: String) {
    _uiState.update { currentState ->
      currentState.copy(
        password = password
      )
    }
  }

  fun setCategory(category: Category) {
    _uiState.update { currentState ->
      currentState.copy(
        category = category
      )
    }
  }

  fun savePassword() {
    viewModelScope.launch(Dispatchers.IO) {
      try {
        repository.insertPassword(
          Password(
            siteName = _uiState.value.siteName,
            siteEmail = _uiState.value.email,
            password = _uiState.value.password,
            lastUpdatedAt = System.currentTimeMillis(),
            id = currentPasswordId
          )
        )
        _eventFlow.emit(UiEvent.SavePassword)
      } catch (e: InvalidPasswordException){
        _eventFlow.emit(
          UiEvent.ShowSnackBar(
            message = e.message ?: "Couldn't save password"
          )
        )
      }

    }
  }

  sealed class UiEvent {
    data class ShowSnackBar(val message: String): UiEvent()
    object SavePassword: UiEvent()
  }
}

