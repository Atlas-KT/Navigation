/*
 * Copyright (c) 2024. Ashley <ax-ie>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 */

package kt.atlas.navigation.navigation

import androidx.compose.runtime.Composable
import kt.atlas.navigation.routable.Routable

interface NavigationHostController<S : Routable> : NavigationController<S> {
    val wrapper: NavigationHostWrapper<S>

    @Composable
    fun construct()
}