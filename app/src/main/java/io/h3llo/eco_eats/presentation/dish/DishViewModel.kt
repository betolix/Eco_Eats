package io.h3llo.eco_eats.presentation.dish

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.h3llo.eco_eats.core.Result
import io.h3llo.eco_eats.data.repository.DishRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DishViewModel : ViewModel() {

    var state by mutableStateOf(DishState())
        private set

    fun getDishes() {

        val repository = DishRepository()


        viewModelScope.launch {

            repository.dishes().onEach{result ->
                when(result){
                    is Result.Error -> {
                        state = state.copy(isLoading = false, error = result.message)
                    }
                    is Result.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is Result.Success -> {
                        state = state.copy(isLoading = false, dishes = result.data )

                    }
                }
            }.launchIn(viewModelScope)

        }

    }


}