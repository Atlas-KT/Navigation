package kt.atlas.navigation

import kt.atlas.navigation.routable.Routables

fun <S : Screen> ScreenStack<S>.navigate(subscreen: S): ScreenHost<S> = host.apply { navigate(subscreen) }

fun <S : Screen> ScreenStack<S>.backTo(subscreen: S, inclusive: Boolean = false): ScreenHost<S> =
    host.apply { backTo(subscreen, inclusive) }

val <S : Screen> ScreenStack<S>.routes: Routables<S>
    get() = host.routables

operator fun <S : Screen> ScreenStack<S>.invoke(screen: S): ScreenStack<S> = apply { navigate(screen) }