/*
 * Copyright (c) 2024. Ashley <ax-ie>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 */

package kt.atlas.navigation

import androidx.compose.runtime.Composable
import kt.atlas.navigation.navigation.NavigationHostWrapper
import kt.atlas.navigation.routable.Routables

abstract class ScreenStack<S : Screen>(
    val host: ScreenHost<S>,

    defaultRoute: String? = null
) : Screen(defaultRoute) {
    constructor(
        routables: Routables<S>,
        wrapper: NavigationHostWrapper<S> = NavigationHostWrapper(),
        defaultRoute: String? = null
    ) : this(
        host = ScreenHost(wrapper, routables),
        defaultRoute = defaultRoute
    )

    constructor(
        default: S,
        vararg others: S,
        wrapper: NavigationHostWrapper<S> = NavigationHostWrapper(),
        defaultRoute: String? = null
    ) : this(
        host = ScreenHost(
            default,
            *others,
            wrapper = wrapper
        ),
        defaultRoute = defaultRoute
    )

    @Composable
    override fun compose() = host.construct()
}