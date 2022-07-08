package com.example.suitmedia.presentasion.screen3.component

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.suitmedia.domain.use_case.GetListUserUseCase
import com.example.suitmedia.presentasion.screen3.ListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.suitmedia.Utils.Condition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@HiltViewModel
class ThirdScreenViewModel @Inject constructor(
    private val getListUserUseCase : GetListUserUseCase
) : ViewModel() {

    private val _state = mutableStateOf<ListState>(ListState())
    val state : State<ListState> = _state

    init {
        getList()
    }


    private fun getList(){
        viewModelScope.launch(Dispatchers.IO){
            getListUserUseCase().onEach { result ->
                when(result){
                    is Condition.Success -> {
                        _state.value = ListState(Lists = result.data ?: emptyList())
                    }
                    is Condition.Error -> {
                        _state.value = ListState(
                            error = result.message ?: "An Unexpected Error Occurred"
                        )

                    }
                    is Condition.Loading ->{
                        _state.value = ListState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

}