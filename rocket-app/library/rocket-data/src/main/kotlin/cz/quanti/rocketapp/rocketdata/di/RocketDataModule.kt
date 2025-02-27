package cz.quanti.rocketapp.rocketdata.di

import cz.quanti.rocketapp.rocketdata.data.SpaceXRocketRepository
import cz.quanti.rocketapp.rocketdata.domain.GetRocketDetailUseCase
import cz.quanti.rocketapp.rocketdata.domain.GetRocketsUseCase
import cz.quanti.rocketapp.rocketdata.domain.RocketRepository
import cz.quanti.rocketapp.rocketdata.system.RetrofitBuilder
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val rocketDataModule = module {
    singleOf(::SpaceXRocketRepository) bind RocketRepository::class
    factoryOf(::GetRocketsUseCase)
    factoryOf(::GetRocketDetailUseCase)
    single { RetrofitBuilder.apiService }
}
