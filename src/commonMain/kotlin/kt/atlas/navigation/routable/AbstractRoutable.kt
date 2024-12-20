/*
 * Copyright (c) 2024. Ashley <ax-ie>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 */

package kt.atlas.navigation.routable

abstract class AbstractRoutable(
    private val defaultRoute: String? = null
) : Routable {
    override val route: String
        get() = defaultRoute ?: constructRoute()

    @OptIn(Internal::class)
    private fun constructRoute(): String = RoutableConverter(this::class)
}