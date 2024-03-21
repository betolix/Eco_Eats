package io.h3llo.eco_eats.presentation.login


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.h3llo.eco_eats.core.Result
import io.h3llo.eco_eats.data.repository.DishRepository
import io.h3llo.eco_eats.data.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(val repository: LoginRepository) : ViewModel(){

    var state by mutableStateOf(LoginState())
    private set

    fun signIn(email:String, password:String){

        //val repository = LoginRepository()

        viewModelScope.launch(Dispatchers.Main) {


            repository.logIn(email, password).onEach {result ->

                when(result){
                    is Result.Error -> {
                        state = state.copy(error = result.message, isLoading = false )

                    }
                    is Result.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is Result.Success -> {
                        state = state.copy(successful = result.data, isLoading = false )
                    }

                    is Result.Unauthorized -> TODO()
                }
            }.launchIn(viewModelScope)


        }

    }

    fun resetData() {
        state = state.copy(successful = null, error = null )
    }
}