package com.nandaadisaputra.semarangtourism.ui.navigation

import com.nandaadisaputra.semarangtourism.data.constant.Const

sealed class Screen(val route: String) {
    object Home : Screen(Const.Cons.HOME)
    object Favorite : Screen(Const.Cons.FAVORITE)
    object AboutMe : Screen(Const.Cons.ABOUT)
    object Detail : Screen(Const.Cons.DETAIL) {
        fun createRoute(tourismId: Int) = "home/$tourismId"
    }

}