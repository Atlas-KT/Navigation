package kt.atlas.navigation.routable.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kt.atlas.navigation.routable.AbstractRoutable

abstract class AbstractComposableRoutable(
    defaultRoute: String? = null
) : AbstractRoutable(defaultRoute), ComposableRoutable {
    @Composable
    override fun composite(compositionStage: CompositionStage) = when (compositionStage) {
        CompositionStage.Prior -> precompose()
        CompositionStage.Composite -> compose()
        CompositionStage.Post -> postcompose()
    }

    override fun construct(builder: NavGraphBuilder) {
        builder.composable(
            route = this@AbstractComposableRoutable.route
        ) {
            composite(CompositionStage.Composite)
        }
    }

    @Composable
    protected open fun precompose() {
    }

    @Composable
    protected abstract fun compose()

    @Composable
    protected open fun postcompose() {
    }
}
