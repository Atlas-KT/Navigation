package kt.atlas.navigation.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kt.atlas.navigation.routable.Routable

class NavigationHostWrapper<S : Routable>(
    val configuration: Configuration = Configuration()
) {
    val hostController: NavHostController
        get() = internalHostController

    private lateinit var internalHostController: NavHostController

    @Composable
    fun begin(
        content: @Composable NavigationHostWrapper<S>.() -> Unit
    ) {
        internalHostController = rememberNavController()

        Surface { content() }
    }

    @Immutable
    data class Configuration(
        val modifier: Modifier = Modifier.fillMaxSize(),

        val enterTransition:
        (@JvmSuppressWildcards
        AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
            {
                fadeIn(animationSpec = tween(350))
            },

        val exitTransition:
        (@JvmSuppressWildcards
        AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
            {
                fadeOut(animationSpec = tween(350))
            }
    )
}