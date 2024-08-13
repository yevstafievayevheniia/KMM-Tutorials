package org.jarvist.kmmapp7.di

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.jarvist.kmmapp7.database.DriverFactory
import org.koin.dsl.module

val jvmModule = module {
    single {
        LifecycleRegistry()
    }
    single<ComponentContext> {
        DefaultComponentContext(
            lifecycle = get<LifecycleRegistry>()
        )
    }
    single {
        DriverFactory()
    }
}

fun startKoinJVM() = initKoin(
    additionalModules = listOf(jvmModule)
)