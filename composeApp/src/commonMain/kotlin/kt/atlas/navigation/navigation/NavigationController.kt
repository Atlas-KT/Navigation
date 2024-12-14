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
import kt.atlas.navigation.routable.Routables

interface NavigationController<S : Routable> {
    val routables: Routables<S>

    val destination: S @Composable get() = lookup()

    val nullableDestination: S? @Composable get() = lookupOrNull()

    fun navigate(route: S): NavigationController<S>

    fun backTo(route: S, inclusive: Boolean = false): NavigationController<S>

    @Composable
    fun lookup(): S = requireNotNull(lookupOrNull())

    @Composable
    fun lookupOrNull(): S?

    @Composable
    fun isCurrentlyOn(route: S): Boolean
}