package org.jarvist.kmmapp7.database

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.jarvist.kmmapp7.AppDatabase

actual class DriverFactory(val context: Context) {
    actual suspend fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            AppDatabase.Schema.synchronous(),
            context = context,
            "app.db"
        )
    }
}