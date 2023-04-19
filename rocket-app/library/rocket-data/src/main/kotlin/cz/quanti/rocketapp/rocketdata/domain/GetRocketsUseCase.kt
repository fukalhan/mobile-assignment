package cz.quanti.rocketapp.rocketdata.domain

import cz.quanti.rocketapp.rocketdata.model.rocket.Rocket

class GetRocketsUseCase internal constructor(private val repository: RocketRepository) {
    suspend fun getRockets(): List<Rocket> {
        return repository.getRockets()
    }
}
