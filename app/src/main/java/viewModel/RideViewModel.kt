package viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.EstimativeRideRequest
import data.repository.RideRepository
import kotlinx.coroutines.launch

class RideViewModel(private val repository: RideRepository) : ViewModel() {

    private val _estimateResponse = MutableLiveData<String>()
    val estimateResponse: LiveData<String> get() = _estimateResponse

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage


    fun estimateRide(request: EstimativeRideRequest) {
        viewModelScope.launch {
            try {
                val response = repository.estimateRide(request)
                _estimateResponse.value = response.toString()
            } catch (e: Exception) {
                _errorMessage.value = "Não deu certo"
            }
        }
    }
}
