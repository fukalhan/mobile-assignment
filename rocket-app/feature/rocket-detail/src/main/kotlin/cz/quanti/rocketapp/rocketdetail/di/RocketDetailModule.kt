package cz.quanti.rocketapp.rocketdetail.di

import cz.quanti.rocketapp.rocketdetail.presentation.RocketDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val rocketDetailModule = module {
    viewModelOf(::RocketDetailViewModel)
}
