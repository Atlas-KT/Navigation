package kt.atlas.navigation.routable.composable

import androidx.compose.runtime.Composable
import kt.atlas.navigation.routable.Routable

interface ComposableRoutable : Routable {
    @Composable
    fun composite(compositionStage: CompositionStage = CompositionStage.Composite)
}

