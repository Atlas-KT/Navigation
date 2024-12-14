package kt.atlas.navigation

import kt.atlas.navigation.routable.composable.AbstractComposableRoutable

abstract class Screen(defaultRoute: String? = null) : AbstractComposableRoutable(defaultRoute)