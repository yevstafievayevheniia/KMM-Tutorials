package org.jarvist.kmmapp7.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.jarvist.kmmapp7.database.Database
import org.jarvist.kmmapp7.database.DatabaseHelper
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

fun cacheModule() = module {
    single {
        DatabaseHelper(get())
    }
    single {
        Database(get(), get())
    }
    single<CoroutineContext> {
        Dispatchers.Default
    }
    single {
        CoroutineScope(get())
    }
}