package cz.quanti.rocketapp.design.di

import cz.quanti.rocketapp.design.presentation.StringResources
import cz.quanti.rocketapp.design.system.AndroidStringResources
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val designModule = module {
    factoryOf(::AndroidStringResources) bind StringResources::class
}
