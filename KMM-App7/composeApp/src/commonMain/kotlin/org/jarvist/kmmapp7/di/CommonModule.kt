package org.jarvist.kmmapp7.di

import org.jarvist.kmmapp7.HomeRepository
import org.jarvist.kmmapp7.HomeViewModel
import org.jarvist.kmmapp7.database.datasource.ProductsLocalDataSource
import org.jarvist.kmmapp7.database.datasource.ProductsRemoteDataSource
import org.jarvist.kmmapp7.root.DefaultRootComponent
import org.jarvist.kmmapp7.root.RootComponent
import org.koin.dsl.module

fun commonModule() = cacheModule() + networkModule() + module {
    single {
        ProductsLocalDataSource(get())
    }
    single {
        ProductsRemoteDataSource(get())
    }
    single {
        HomeRepository(get(), get())
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