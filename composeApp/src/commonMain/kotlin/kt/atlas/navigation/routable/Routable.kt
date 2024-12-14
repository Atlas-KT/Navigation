package kt.atlas.navigation.routable

import kt.atlas.navigation.adaption.NavAdapter

interface Routable : NavAdapter {
    val route: String
}
