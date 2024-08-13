package org.jarvist.kmmapp7.database

import app.cash.sqldelight.async.coroutines.awaitCreate
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import org.jarvist.kmmapp7.AppDatabase
import org.w3c.dom.Worker

actual class DriverFactory {
    actual suspend fun createDriver(): SqlDriver {
        val driver = WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
        AppDatabase.Schema.awaitCreate(driver)
        return driver
    }
}