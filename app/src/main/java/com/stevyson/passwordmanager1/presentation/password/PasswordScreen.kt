package com.stevyson.passwordmanager1.presentation.password

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.stevyson.passwordmanager1.R
import com.stevyson.passwordmanager1.domain.model.Category
import com.stevyson.passwordmanager1.domain.model.Password
import com.stevyson.passwordmanager1.presentation.password.components.AddButton
import com.stevyson.passwordmanager1.presentation.password.components.PasswordListItem
import com.stevyson.passwordmanager1.presentation.password.components.SearchBox
import com.stevyson.passwordmanager1.ui.theme.Background
import com.stevyson.passwordmanager1.ui.theme.MainTextColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordScreen(drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
                   navController: NavController,
                   vm: PasswordViewModel = hiltViewModel()
) {

    val state by vm.uiState.collectAsState()

    val item = state.passwords

    val socialList: MutableList<Password> = mutableListOf()
    val streamingList: MutableList<Password> = mutableListOf()

    val walletList: MutableList<Password> = mutableListOf()
    val appList: MutableList<Password> = mutableListOf()


    for (i in item){
        if (i.category == Category.Social.name){
            socialList.add(element = i)
        }
        if (i.category == Category.Streaming.name){
            streamingList.add(element = i)
        }
        if (i.category == Category.Wallet.name){
            walletList.add(element = i)
        }
        if (i.category == Category.Apps.name){
            appList.add(element = i)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    "Passwords",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.ExtraBold,
                    color = MainTextColor
                )
            },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Background
                ),
                navigationIcon = {
                    Surface(
                        onClick = {
                            navController.navigateUp()
                        },
                        color = Color.Transparent,
                    ) {
                        Row(modifier = Modifier.padding(vertical = 10.dp)) {
                            Icon(
                                Icons.Rounded.ArrowBack,
                                contentDescription = "Settings",
                                tint = MainTextColor
                            )
                        }
                    }
                })
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .background(Background)
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    SearchBox(modifier = Modifier)
                    AddButton {}
                }
                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier.scrollable(rememberScrollState(), Orientation.Vertical)
                ) {
                        Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.Start,
                            ) {
                                Text(
                                    text = "Social",
                                    fontSize = 20.sp,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = MainTextColor
                                )
                            }

                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(13.dp)
                            ) {

                                items(socialList) { password ->
                                    PasswordListItem(
                                        password = password,
                                        image = R.drawable.windows_icon,
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        navController = navController

                                    )
                                }
                            }




                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.Start,
                        ) {
                            Text(
                                text = "Streaming",
                                fontSize = 20.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.ExtraBold,
                                color = MainTextColor
                            )
                        }

                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(13.dp)
                            ) {

                                items(streamingList) { password ->
                                    PasswordListItem(
                                        password = password,
                                        image = R.drawable.windows_icon,
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        navController = navController

                                    )
                                }
                            }



                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.Start,
                        ) {
                            Text(
                                text = "Wallet",
                                fontSize = 20.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.ExtraBold,
                                color = MainTextColor
                            )
                        }
                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(13.dp)
                            ) {

                                items(walletList) { password ->
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




                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.Start,
                        ) {
                            Text(
                                text = "Apps",
                                fontSize = 20.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.ExtraBold,
                                color = MainTextColor
                            )
                        }

                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(13.dp)
                            ) {

                                items(appList) { password ->
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
    )






}
//
//@Preview
//@Composable
//fun PreviewPass() {
//    PasswordManager1Theme {
//        PasswordScreen()
//    }
//}