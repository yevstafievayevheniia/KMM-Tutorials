package org.jarvist.kmmapp6.di

import org.jarvist.kmmapp6.HomeRepository
import org.jarvist.kmmapp6.HomeViewModel
import org.jarvist.kmmapp6.root.DefaultRootComponent
import org.jarvist.kmmapp6.root.RootComponent
import org.koin.dsl.module

fun commonModule() = networkModule() + module {
    single {
        HomeRepository(get())
    }
    single {
        HomeViewModel(get())
    }
    single<RootComponent> {
        DefaultRootComponent(
            componentContext = get(),
            homeViewModel = get()
        )
    }
}