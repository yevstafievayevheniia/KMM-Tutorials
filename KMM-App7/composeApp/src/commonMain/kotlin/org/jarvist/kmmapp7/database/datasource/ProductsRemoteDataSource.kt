package org.jarvist.kmmapp7.database.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.jarvist.kmmapp7.data.Product

class ProductsRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getAllProducts(): List<Product> {
        val response = httpClient.get("https://fakestoreapi.com/products")
        return response.body()
    }
}