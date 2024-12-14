package kt.atlas.navigation.navigation

import androidx.compose.runtime.Composable
import kt.atlas.navigation.routable.Routable
import kt.atlas.navigation.routable.Routables

interface NavigationController<S : Routable> {
    val routables: Routables<S>

    val destination: S @Composable get() = lookup()

    val nullableDestination: S? @Composable get() = lookupOrNull()

    fun navigate(route: S): NavigationController<S>

    fun backTo(route: S, inclusive: Boolean = false): NavigationController<S>

    @Composable
    fun lookup(): S = requireNotNull(lookupOrNull())

    @Composable
    fun lookupOrNull(): S?

    @Composable
    fun isCurrentlyOn(route: S): Boolean
}