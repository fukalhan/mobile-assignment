package cz.quanti.rocketapp.app.di

import cz.quanti.rocketapp.app.system.App
import cz.quanti.rocketapp.design.di.designModule
import cz.quanti.rocketapp.rocketdata.di.rocketDataModule
import cz.quanti.rocketapp.rocketdetail.di.rocketDetailModule
import cz.quanti.rocketapp.rocketlist.di.rocketListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun setupKoin(app: App) {
    startKoin {
        androidContext(app)
        modules(
            listOf(
                designModule,
                rocketListModule,
                rocketDetailModule,
                rocketDataModule
            )
        )
    }
}
