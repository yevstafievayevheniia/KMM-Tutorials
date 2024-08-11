package org.jarvist.kmmapp6

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jarvist.kmmapp6.data.Product

class HomeViewModel: ViewModel() {

    private val homeRepository = HomeRepository()

    private val _products = MutableStateFlow<List<Product>>(listOf())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch {
            homeRepository.getProducts().collect { products ->
                _products.update { it + products }
            }
        }
    }
}