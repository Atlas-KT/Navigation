package kt.atlas.navigation

import androidx.compose.runtime.Composable
import kt.atlas.navigation.navigation.NavigationHostWrapper
import kt.atlas.navigation.routable.Routables

abstract class ScreenStack<S : Screen>(
    val host: ScreenHost<S>,

    defaultRoute: String? = null
) : Screen(defaultRoute) {
    constructor(
        routables: Routables<S>,
        wrapper: NavigationHostWrapper<S> = NavigationHostWrapper(),
        defaultRoute: String? = null
    ) : this(
        host = ScreenHost(wrapper, routables),
        defaultRoute = defaultRoute
    )

    constructor(
        default: S,
        vararg others: S,
        wrapper: NavigationHostWrapper<S> = NavigationHostWrapper(),
        defaultRoute: String? = null
    ) : this(
        host = ScreenHost(
            default,
            *others,
            wrapper = wrapper
        ),
        defaultRoute = defaultRoute
    )

    @Composable
    override fun compose() = host.construct()
}