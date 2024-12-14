package kt.atlas.navigation

import kt.atlas.navigation.navigation.AbstractNavigationHostController
import kt.atlas.navigation.navigation.NavigationHostWrapper
import kt.atlas.navigation.routable.Routables

open class ScreenHost<S : Screen> : AbstractNavigationHostController<S> {
    constructor(
        wrapper: NavigationHostWrapper<S> = NavigationHostWrapper(),
        routables: Routables<S>
    ) : super(wrapper, routables)

    constructor(default: S, vararg others: S, wrapper: NavigationHostWrapper<S> = NavigationHostWrapper()) : super(
        default,
        *others,
        wrapper = wrapper
    )
}
