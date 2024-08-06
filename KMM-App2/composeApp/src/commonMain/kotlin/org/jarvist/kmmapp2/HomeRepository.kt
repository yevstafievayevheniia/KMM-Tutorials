package org.jarvist.kmmapp2

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import org.jarvist.kmmapp2.apiClient.httpClient
import org.jarvist.kmmapp2.data.Product

class HomeRepository {

    suspend fun getProductsAPI(): List<Product> {
        val response = httpClient.get("https://fakestoreapi.com/products")
        return response.body()
    }

    fun getProducts() = flow {
        emit(getProductsAPI())
    }
}