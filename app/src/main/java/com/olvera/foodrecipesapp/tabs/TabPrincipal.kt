package com.olvera.foodrecipesapp.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.*
import com.olvera.foodrecipesapp.R
import com.olvera.foodrecipesapp.composables.BackNavigationIcon
import kotlinx.coroutines.launch

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun TabPrincipal(
    onNavigationIconClick: () -> Unit,
) {

    val tabs = listOf(
        TabItem.ItemOverview,
        TabItem.ItemIngredients,
        TabItem.ItemInstructions
    )

    val pagerState = rememberPagerState()

    Scaffold(topBar = {
        FoodRecipeScreenTopBar(onNavigationIconClick)
    }) {
        Column() {
            Tabs(tabs, pagerState)
            TabsContent(tabs, pagerState)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {

    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].screen()
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    TabRow(selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {

        tabs.forEachIndexed { index, tabItem ->
            LeadingIconTab(
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                text = { Text(text = tabItem.title) },
                icon = {}
            )
        }

    }

}

@Composable
fun FoodRecipeScreenTopBar(onClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.title_activity_food_recipe_detail)) },
        backgroundColor = colorResource(id = R.color.purple_500),
        contentColor = Color.White,
        navigationIcon = { BackNavigationIcon(onClick) }
    )
}