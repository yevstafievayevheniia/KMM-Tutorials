package org.jarvist.kmmapp6.detail

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import org.jarvist.kmmapp6.data.Product

interface DetailComponent {

    val model: Value<Model>

    fun onBackPressed() {}

    data class Model(
        val item: Product
    )
}

class DefaultLDetailComponent(
    private val componentContext: ComponentContext,
    private val item: Product,
    private val onBackAction: () -> Unit
): DetailComponent, ComponentContext by componentContext {

    private val _model = MutableValue(DetailComponent.Model(item = item))
    override val model: Value<DetailComponent.Model> = _model

    override fun onBackPressed() {
        onBackAction()
    }
}