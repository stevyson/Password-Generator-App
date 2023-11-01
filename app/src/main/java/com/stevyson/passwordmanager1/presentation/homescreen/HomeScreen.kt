package com.stevyson.passwordmanager1.presentation.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.stevyson.passwordmanager1.R
import com.stevyson.passwordmanager1.Screen
import com.stevyson.passwordmanager1.presentation.homescreen.components.HomeSearchBox
import com.stevyson.passwordmanager1.presentation.homescreen.components.MyAccountsTab
import com.stevyson.passwordmanager1.presentation.password.PasswordViewModel
import com.stevyson.passwordmanager1.presentation.password.components.PasswordListItem
import com.stevyson.passwordmanager1.ui.theme.Background
import com.stevyson.passwordmanager1.ui.theme.BackgroundElevated
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.SearchBarBorderColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    drawerState: DrawerState= rememberDrawerState(initialValue = DrawerValue.Closed),
    vm: PasswordViewModel = hiltViewModel()
){

    val state by vm.uiState.collectAsState()

    data class NavigationItem(
        val route: String,
        val title: String,
        val selectedIcon: ImageVector,
        val unselectedIcon: ImageVector,
        val badgeCount: Int? = null
    )



    val items = listOf(
        NavigationItem(
            route = Screen.AddScreen.route,
            title = "Add",
            selectedIcon = Icons.Filled.Add,
            unselectedIcon = Icons.Outlined.Add
        ),
        NavigationItem(
            route = Screen.GeneratorScreen.route,
            title = "Generate new password",
            selectedIcon = Icons.Filled.Create,
            unselectedIcon = Icons.Outlined.Create
        ),
        NavigationItem(
            route = Screen.PasswordScreen.route,
            title = "Passwords",
            selectedIcon = Icons.Filled.Lock,
            unselectedIcon = Icons.Outlined.Lock
        ),

        )

    Surface(
        modifier = Modifier
            .fillMaxSize()
        ,
        color = BackgroundElevated
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerContent = {
                Spacer(modifier = Modifier.height(16.dp))
                 ModalDrawerSheet(
                     drawerContainerColor = Background,
                     drawerContentColor = BackgroundElevated,

                 ) {
                     NavigationDrawerItem(
                         colors = NavigationDrawerItemDefaults.colors(
                             selectedContainerColor = BackgroundElevated,
                             unselectedContainerColor = Background,
                             unselectedTextColor = MainTextColor
                         ),
                         label = {
                             Text(text = "Add")
                         },
                         selected = false ,
                         onClick = {
                             navController.navigate(route = Screen.AddScreen.route){
                                 popUpTo(Screen.PasswordScreen.route)
                             }

                             scope.launch {
                                 drawerState.close()
                             }
                         },
                         icon = {
                             Icon(
                                 imageVector =
                                     Icons.Filled.Add,
                                 contentDescription = "Add"
                             )
                         },
                         modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                     )
                     NavigationDrawerItem(
                         colors = NavigationDrawerItemDefaults.colors(
                             selectedContainerColor = BackgroundElevated,
                             unselectedContainerColor = Background,
                             unselectedTextColor = MainTextColor
                         ),
                         label = {
                             Text(text = "Generate new password")
                         },
                         selected = false ,
                         onClick = {
                             navController.navigate(route = Screen.GeneratorScreen.route){
                                 popUpTo(Screen.PasswordScreen.route)
                             }

                             scope.launch {
                                 drawerState.close()
                             }
                         },
                         icon = {
                             Icon(
                                 imageVector =
                                 Icons.Filled.Create,
                                 contentDescription = "Create"
                             )
                         },
                         modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                     )
                     NavigationDrawerItem(
                         colors = NavigationDrawerItemDefaults.colors(
                             selectedContainerColor = BackgroundElevated,
                             unselectedContainerColor = Background,
                             unselectedTextColor = MainTextColor
                         ),
                         label = {
                             Text(text = "Passwords")
                         },
                         selected = false ,
                         onClick = {
                             navController.navigate(route = Screen.PasswordScreen.route){
                                 popUpTo(Screen.HomeScreen.route)
                             }

                             scope.launch {
                                 drawerState.close()
                             }
                         },
                         icon = {
                             Icon(
                                 imageVector =
                                 Icons.Filled.Lock,
                                 contentDescription = "password"
                             )
                         },
                         modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                     )

                 }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.mediumTopAppBarColors(
                            containerColor = Background,
                            titleContentColor = Background,

                            ),
                        title = {
                            Text(
                                "",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = MainTextColor
                            )

                        },

                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "menu",
                                    tint = SearchBarBorderColor,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = { navController.navigate(route = Screen.AddScreen.route) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Notifications,
                                    contentDescription = "Notification",
                                    tint = SearchBarBorderColor,
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Image(
                                    painter = painterResource(id = R.drawable.windows_icon),
                                    contentDescription = "icon",
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        },

                    )
                },
                content = { innerPadding ->
                    Column(
                        modifier = Modifier
                            .background(Background)
                            .padding(innerPadding)
                            .padding(horizontal = 20.dp)
                            .fillMaxSize()
                            ,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp),
                            horizontalArrangement = Arrangement.Start,
                        ) {
                            Text(
                                text = "Welcome Back",
                                fontSize = 15.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Medium,
                                color = MainTextColor
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                        ) {
                            Text(
                                text = "Sammy Waghat",
                                fontSize = 30.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.ExtraBold,
                                color = MainTextColor
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 15.dp),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            HomeSearchBox()
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 11.dp),
                            horizontalArrangement = Arrangement.Start,
                        ) {
                            Text(
                                text = "My Accounts",
                                fontSize = 15.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Medium,
                                color = MainTextColor
                            )
                        }

                        MyAccountsTab()


                        Column(
                            modifier = Modifier.scrollable(
                                rememberScrollState(),
                                orientation = Orientation.Vertical
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.Start,
                            ) {
                                Text(
                                    text = "Latest Account",
                                    fontSize = 15.sp,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Medium,
                                    color = MainTextColor
                                )
                            }

                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(13.dp)
                            ) {
                                items(state.passwords) { password ->
                                    PasswordListItem(
                                        password = password,
                                        image = R.drawable.windows_icon,
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        navController = navController
                                    )
                                }
                            }

                        }

                    }
                }
            )
        }
    }
}


//
//@OptIn(ExperimentalMaterial3Api::class)
//@Preview
//@Composable
//fun PreviewHome() {
//    PasswordManager1Theme {
//        HomeScreen(rememberDrawerState(initialValue = DrawerValue.Closed))
//    }
//}