package cz.quanti.rocketapp.rocketdata.domain

import cz.quanti.rocketapp.rocketdata.model.Rocket
import cz.quanti.rocketapp.rocketdata.model.rocketdetail.RocketDetail

internal interface RocketRepository {
    suspend fun getRockets(): List<Rocket>
    suspend fun getRocketDetail(id: String): RocketDetail
}
