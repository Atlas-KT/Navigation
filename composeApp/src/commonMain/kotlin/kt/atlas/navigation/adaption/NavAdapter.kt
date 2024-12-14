/*
 * Copyright (c) 2024. Ashley <ax-ie>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 */

package kt.atlas.navigation.adaption

import androidx.navigation.NavGraphBuilder

fun interface NavAdapter {
    fun construct(builder: NavGraphBuilder)
}

fun NavGraphBuilder.route(adapter: NavAdapter) = adapter.construct(this)