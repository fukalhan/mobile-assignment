package cz.quanti.rocketapp.rocketdetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.quanti.rocketapp.design.presentation.StringResources
import cz.quanti.rocketapp.rocketdata.domain.GetRocketDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RocketDetailViewModel(
    private val getRocketDetailUseCase: GetRocketDetailUseCase,
    private val stringResources: StringResources
) : ViewModel() {
    private val _rocketDetail = MutableStateFlow(RocketDetailState())
    val rocketDetail: StateFlow<RocketDetailState>
        get() = _rocketDetail

    fun initRocketDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val rocketDetail = getRocketDetailUseCase.getRocketDetail(id)
            val rocketDetailState = rocketDetail.toRocketDetailState(stringResources)
            _rocketDetail.value = rocketDetailState
        }
    }
}
