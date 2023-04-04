package cz.quanti.rocketapp.rocketdetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.quanti.rocketapp.rocketdata.domain.GetRocketDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RocketDetailViewModel(private val getRocketDetailUseCase: GetRocketDetailUseCase) : ViewModel() {
    private val _rocketDetail = MutableStateFlow(RocketDetailState())
    val rocketDetail: StateFlow<RocketDetailState>
        get() = _rocketDetail

    fun getRocketDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _rocketDetail.value = getRocketDetailUseCase.getRocketDetail(id).toRocketDetailState()
        }
    }
}
