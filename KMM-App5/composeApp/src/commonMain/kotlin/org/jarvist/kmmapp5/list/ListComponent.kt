package org.jarvist.kmmapp5.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jarvist.kmmapp5.HomeViewModel
import org.jarvist.kmmapp5.data.Product

interface ListComponent {

    val model: Value<Model>

    fun onItemPressed(item: Product) {}

    data class Model(
        val items: List<Product>
    )
}

class DefaultListComponent(
    private val componentContext: ComponentContext,
    private val homeViewModel: HomeViewModel,
    private val onItemAction: (item: Product) -> Unit
): ListComponent, ComponentContext by componentContext {

    private val _model = MutableValue(ListComponent.Model(items = emptyList()))
    override val model: Value<ListComponent.Model> = _model

    init {
        CoroutineScope(Dispatchers.Default).launch {
            homeViewModel.products.collect {
                _model.value = ListComponent.Model(items = it)
            }
        }
    }

    override fun onItemPressed(item: Product) {
        onItemAction(item)
    }
}