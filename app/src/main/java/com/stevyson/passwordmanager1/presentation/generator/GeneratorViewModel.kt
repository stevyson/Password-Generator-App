package com.stevyson.passwordmanager1.presentation.generator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.stevyson.passwordmanager1.domain.repository.PasswordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class GeneratorState(
    var passwordStrength: Float = 0.2f,
    var generatedPassword: String = "",
    var passwordLength: Float = 8f,
    var addDigits: Boolean = true,
    var addLetters: Boolean = true,
    var addSymbols: Boolean = true,
    var addChar: Boolean = false
)


@HiltViewModel
class GeneratorViewModel  @Inject constructor(
    private val repository: PasswordRepository
) : ViewModel() {


    private val _uiState = MutableStateFlow(GeneratorState())
    val uiState: StateFlow<GeneratorState> = _uiState.asStateFlow()



    private val symbols: List<String> = listOf("!","@","#","$","%","^","&","*","(",")","-","+","=")
    private val characters: List<String> = listOf(":",";","'","<",">","?","/",",","`","~")

    var allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')  + symbols

    fun generatePassword(length: Int) : String {
        if (_uiState.value.addLetters){
             allowedChars = ('A'..'Z') + ('a'..'z')
        }
        if (_uiState.value.addDigits){
            allowedChars =  ('0'..'4') + ('5'..'9')
        }
        if (_uiState.value.addLetters && _uiState.value.addDigits){
            allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        }
        if (_uiState.value.addLetters && _uiState.value.addDigits && _uiState.value.addSymbols){
            allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')  + symbols
        }
        if (_uiState.value.addLetters && _uiState.value.addDigits && _uiState.value.addSymbols && _uiState.value.addChar) {
            allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')  + symbols + characters
        }
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")

    }


    fun updateSlider(passwordLength: Float) {
        _uiState.update { currentState ->
            currentState.copy(
                passwordLength = passwordLength,
            )
        }
    }


}