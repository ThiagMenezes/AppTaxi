import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import data.repository.RideRepository
import viewModel.RideViewModel

class RideViewModelFactory(
    private val repository: RideRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RideViewModel::class.java)) {
            return RideViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
