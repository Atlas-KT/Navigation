package kt.atlas.navigation.shared

fun interface Converter<S, O> {
    fun remap(source: S): O

    operator fun invoke(source: S): O = remap(source)
}