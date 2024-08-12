package org.jarvist.kmmapp7.di

import org.jarvist.kmmapp7.HomeRepository
import org.jarvist.kmmapp7.HomeViewModel
import org.jarvist.kmmapp7.root.DefaultRootComponent
import org.jarvist.kmmapp7.root.RootComponent
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