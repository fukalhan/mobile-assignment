package cz.quanti.rocketapp.rocketdata.domain

import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail

class GetRocketDetailUseCase internal constructor(private val repository: RocketRepository) {

    suspend fun getRocketDetail(id: String): RocketDetail {
        return repository.getRocketDetail(id)
    }
}
