/*
 * Copyright (c) 2024. Ashley <ax-ie>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 */

package kt.atlas.navigation.routable.composable

import androidx.compose.runtime.Composable
import kt.atlas.navigation.routable.Routable

interface ComposableRoutable : Routable {
    @Composable
    fun composite(compositionStage: CompositionStage = CompositionStage.Composite)
}

