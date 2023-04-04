package cz.quanti.rocketapp.rocketdata.domain

import cz.quanti.rocketapp.rocketdata.data.rocket.RocketResponse
import cz.quanti.rocketapp.rocketdata.data.rocketdetail.RocketDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface RocketApiService {
    @GET("rockets")
    suspend fun getRockets(): List<RocketResponse>

    @GET("rockets/{rocketId}")
    suspend fun getRocketDetail(@Path("rocketId") id: String): RocketDetailResponse
}
