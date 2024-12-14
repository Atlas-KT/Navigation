package kt.atlas.navigation.routable

abstract class AbstractRoutable(
    private val defaultRoute: String? = null
) : Routable {
    override val route: String
        get() = defaultRoute ?: constructRoute()

    @OptIn(Internal::class)
    private fun constructRoute(): String = RoutableConverter(this::class)
}