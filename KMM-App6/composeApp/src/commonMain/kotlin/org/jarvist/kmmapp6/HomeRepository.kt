package org.jarvist.kmmapp6

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import org.jarvist.kmmapp6.data.Product

class HomeRepository(
    private val httpClient: HttpClient
) {
    suspend fun getProductsAPI(): List<Product> {
        val response = httpClient.get("https://fakestoreapi.com/products")
        return response.body()
    }

    fun getProducts() = flow {
        emit(getProductsAPI())
    }
}