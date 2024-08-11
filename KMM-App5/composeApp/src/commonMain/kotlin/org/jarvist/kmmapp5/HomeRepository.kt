package org.jarvist.kmmapp5

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import org.jarvist.kmmapp5.apiClient.httpClient
import org.jarvist.kmmapp5.data.Product

class HomeRepository {

    suspend fun getProductsAPI(): List<Product> {
        val response = httpClient.get("https://fakestoreapi.com/products")
        return response.body()
    }

    fun getProducts() = flow {
        emit(getProductsAPI())
    }
}