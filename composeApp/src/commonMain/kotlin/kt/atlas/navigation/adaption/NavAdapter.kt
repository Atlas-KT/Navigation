package kt.atlas.navigation.adaption

import androidx.navigation.NavGraphBuilder

fun interface NavAdapter {
    fun construct(builder: NavGraphBuilder)
}

fun NavGraphBuilder.route(adapter: NavAdapter) = adapter.construct(this)