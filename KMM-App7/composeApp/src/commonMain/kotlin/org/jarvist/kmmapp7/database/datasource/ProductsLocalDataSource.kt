package org.jarvist.kmmapp7.database.datasource

import org.jarvist.kmmapp7.data.Product
import org.jarvist.kmmapp7.database.Database

class ProductsLocalDataSource(
    private val database: Database
) {
    suspend fun getAllProducts(): List<Product> {
        return database.getAllProducts()
    }

    suspend fun clearDatabase() {
        return database.clearDatabase()
    }

    suspend fun saveProducts(items: List<Product>) {
        return database.createProducts(items)
    }
}