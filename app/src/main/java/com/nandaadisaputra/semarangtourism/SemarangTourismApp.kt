package com.nandaadisaputra.semarangtourism


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nandaadisaputra.semarangtourism.ui.about.AboutScreen
import com.nandaadisaputra.semarangtourism.ui.detail.DetailScreen
import com.nandaadisaputra.semarangtourism.ui.favorite.FavoriteScreen
import com.nandaadisaputra.semarangtourism.ui.home.HomeScreen
import com.nandaadisaputra.semarangtourism.ui.navigation.NavigationItem
import com.nandaadisaputra.semarangtourism.ui.navigation.Screen

@Composable
fun SemarangTourismApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    BottomNavigation(
        modifier = modifier
    ) {
        Scaffold(
            bottomBar = {
                BottomBar(navController)
            },
            modifier = modifier
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                composable(Screen.Home.route) {
                    HomeScreen(
                        navigateToDetail = { tourismId ->
                            navController.navigate(
                                Screen.Detail.createRoute(
                                    tourismId
                                )
                            )
                        }
                    )
                }
                composable(
                    route = Screen.Detail.route,
                    arguments = listOf(
                        navArgument("id") { type = NavType.IntType }
                    )
                ) {
                    val id = it.arguments?.getInt("id") ?: -1
                    DetailScreen(
                        tourismId = id,
                        navigateBack = {
                            navController.navigateUp()
                        }
                    )
                }
                composable(Screen.Favorite.route) {
                    FavoriteScreen()
                }
                composable(Screen.AboutMe.route) {
                    AboutScreen()
                }
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = painterResource(id = R.drawable.ic_home),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_favorite),
                icon = painterResource(id = R.drawable.ic_favorite),
                screen = Screen.Favorite
            ),
            NavigationItem(
                title = stringResource(R.string.menu_about),
                icon = painterResource(id = R.drawable.ic_person),
                screen = Screen.AboutMe
            ),
        )
        navigationItems.map { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 11.sp
                    )
                },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}