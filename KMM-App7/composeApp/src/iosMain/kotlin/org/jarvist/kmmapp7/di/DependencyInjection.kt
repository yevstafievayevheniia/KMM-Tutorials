package org.jarvist.kmmapp7.di

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.jarvist.kmmapp7.database.DriverFactory
import org.jarvist.kmmapp7.root.RootComponent
import org.koin.core.Koin
import org.koin.dsl.module

val iOSModule = module {
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

fun initKoinIOS() = initKoin(
    additionalModules = listOf(iOSModule)
)

val Koin.rootComponent: RootComponent
    get() = get()
val Koin.lifecycleRegistry: LifecycleRegistry
    get() = get()