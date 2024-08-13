package org.jarvist.kmmapp7.database

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.jarvist.kmmapp7.AppDatabase

actual class DriverFactory {
    actual suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            AppDatabase.Schema.synchronous(),
            "app.db"
        )
    }
}