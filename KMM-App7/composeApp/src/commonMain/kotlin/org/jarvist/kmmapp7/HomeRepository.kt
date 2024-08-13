package org.jarvist.kmmapp7

import kotlinx.coroutines.flow.flow
import org.jarvist.kmmapp7.data.Product
import org.jarvist.kmmapp7.database.datasource.ProductsLocalDataSource
import org.jarvist.kmmapp7.database.datasource.ProductsRemoteDataSource

class HomeRepository(
    private val productsLocalDataSource: ProductsLocalDataSource,
    private val productsRemoteDataSource: ProductsRemoteDataSource
) {
    private suspend fun getAllProducts(forceReload: Boolean = false): List<Product> {
        val cacheItems = productsLocalDataSource.getAllProducts()
        return if(cacheItems.isNotEmpty() &&  !forceReload) {
            println("fromCache")
            cacheItems
        } else {
            println("fromNetwork")
            productsRemoteDataSource.getAllProducts().also {
                productsLocalDataSource.clearDatabase()
                productsLocalDataSource.saveProducts(it)
            }
        }
    }

    fun getProducts(forceReload: Boolean = false) = flow {
        emit(getAllProducts(forceReload))
    }
}