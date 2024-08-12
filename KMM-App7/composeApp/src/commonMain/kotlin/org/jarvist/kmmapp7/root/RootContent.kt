package org.jarvist.kmmapp7.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import org.jarvist.kmmapp7.detail.DetailContent
import org.jarvist.kmmapp7.list.ListContent

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) { it ->
        when(val child = it.instance) {
            is RootComponent.Child.ListChild -> ListContent(child.component)
            is RootComponent.Child.DetailChild -> DetailContent(child.component)
        }
    }
}
