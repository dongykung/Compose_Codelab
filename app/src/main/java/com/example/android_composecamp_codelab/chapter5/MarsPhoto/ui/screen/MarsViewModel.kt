package com.example.android_composecamp_codelab.chapter5.MarsPhoto.ui.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.MarsPhotosApplication
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.data.MarsPhoto
import com.example.android_composecamp_codelab.chapter5.MarsPhoto.data.MarsPhotosRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    object Loading : MarsUiState
    object Error : MarsUiState
}

class MarsViewModel(private val marsPhotosRepository: MarsPhotosRepository) : ViewModel() {

    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    init {
        getMarsPhotos()
    }

     fun getMarsPhotos() {
        viewModelScope.launch {
            marsUiState = try {
                //viewmodel이 네트워크 요청을 직접하지 않고 저장소가 데이터를 제공한다.
                //더이상 MarsApi의 코드를 참조하지 않는다 = 관심사 분리
                val listResult = marsPhotosRepository.getMarsPhotos()
                MarsUiState.Success(listResult)
            } catch (e: IOException) {
                MarsUiState.Error
            }

        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
                val marsPhotosRepository = application.container.marsPhotosRepository
                MarsViewModel(marsPhotosRepository = marsPhotosRepository)
            }
        }
    }
}