package kt.atlas.navigation.navigation

import androidx.compose.runtime.Composable
import kt.atlas.navigation.routable.Routable

interface NavigationHostController<S : Routable> : NavigationController<S> {
    val wrapper: NavigationHostWrapper<S>

    @Composable
    fun construct()
}