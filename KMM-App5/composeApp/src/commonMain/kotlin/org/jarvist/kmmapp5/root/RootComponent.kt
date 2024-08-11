package org.jarvist.kmmapp5.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.StackNavigator
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import io.ktor.client.plugins.HttpSend
import kotlinx.serialization.Serializable
import org.jarvist.kmmapp5.HomeViewModel
import org.jarvist.kmmapp5.data.Product
import org.jarvist.kmmapp5.detail.DefaultLDetailComponent
import org.jarvist.kmmapp5.detail.DetailComponent
import org.jarvist.kmmapp5.list.DefaultListComponent
import org.jarvist.kmmapp5.list.ListComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onBackPressed() {}

    sealed class Child {
        class ListChild(val component: ListComponent): Child()
        class DetailChild(val component: DetailComponent): Child()
    }
}

class DefaultRootComponent(
    private val componentContext: ComponentContext,
    private val homeViewModel: HomeViewModel
): RootComponent, ComponentContext by componentContext {

    @Serializable
    sealed interface Config {
        @Serializable
        data object List: Config
        @Serializable
        data class Detail(val item: Product): Config
    }

    private val navigation = StackNavigation<Config>()

    private fun childFactory(config: Config, componentContext: ComponentContext): RootComponent.Child {
        return when(config) {
            is Config.List -> RootComponent.Child.ListChild(
                DefaultListComponent(
                    componentContext,
                    homeViewModel
                ) { item ->
                    navigation.push(Config.Detail(item))
                }
            )
            is Config.Detail -> RootComponent.Child.DetailChild(
                DefaultLDetailComponent(
                    componentContext,
                    config.item
                ) {
                    navigation.pop()
                }
            )
        }
    }

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.List,
            handleBackButton = true,
            childFactory = ::childFactory
        )

    override fun onBackPressed() {
        navigation.pop()
    }
}