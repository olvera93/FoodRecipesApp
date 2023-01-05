package com.olvera.foodrecipesapp

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.olvera.foodrecipesapp.util.ItemsMenu
import com.olvera.foodrecipesapp.util.NavigationHost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun Home() {

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigationItem = listOf(
        ItemsMenu.Main,
        ItemsMenu.FoodRecipeJoke
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { InferiorNavigation(navController, navigationItem) },
        floatingActionButton = { Fab(scope, scaffoldState) },
        isFloatingActionButtonDocked = true
    ) {
        NavigationHost(navController)
    }
}

@Composable
fun Fab(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    FloatingActionButton(
        onClick = {
            scope.launch {
                scaffoldState.snackbarHostState
                    .showSnackbar(
                        "Test",
                        actionLabel = "Accept",
                        duration = SnackbarDuration.Indefinite
                    )
            }
        }
    ) {

        Icon(imageVector = Icons.Filled.List, contentDescription = "Soon")


    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val origin by navController.currentBackStackEntryAsState()
    return origin?.destination?.route
}

@Composable
fun InferiorNavigation(navController: NavHostController, navigationItem: List<ItemsMenu>) {

    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        )
    ) {
        BottomNavigation(
            modifier = Modifier.padding(0.dp, 0.dp, 60.dp, 0.dp)
        ) {
            val currentRoute = currentRoute(navController = navController)
            navigationItem.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.route,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    alwaysShowLabel = false
                )
            }

        }

    }

}

