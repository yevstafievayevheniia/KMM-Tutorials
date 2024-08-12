package org.jarvist.kmmapp6.di

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.jarvist.kmmapp6.root.RootComponent
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
}

fun initKoinIOS() = initKoin(
    additionalModules = listOf(iOSModule)
)

val Koin.rootComponent: RootComponent
    get() = get()
val Koin.lifecycleRegistry: LifecycleRegistry
    get() = get()