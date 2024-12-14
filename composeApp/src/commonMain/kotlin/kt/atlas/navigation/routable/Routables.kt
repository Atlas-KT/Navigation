package kt.atlas.navigation.routable

class Routables<S : Routable>(
    val default: S,
    vararg others: S
) : MutableMap<String, S> by mutableMapOf(), Iterable<S> {
    init {
        register(default)
        registerAll(*others)
    }

    private fun register(routable: S): Routables<S> = apply {
        this[routable.route] = routable
    }

    private fun registerAll(vararg routables: S): Routables<S> = apply {
        routables.forEach { register(it) }
    }

    override fun iterator(): Iterator<S> = values.iterator()
}