package com.stevyson.passwordmanager1.presentation.password.add_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.stevyson.passwordmanager1.Screen
import com.stevyson.passwordmanager1.domain.model.Category
import com.stevyson.passwordmanager1.presentation.password.components.TableRow
import com.stevyson.passwordmanager1.presentation.password.components.UnStyledTextField
import com.stevyson.passwordmanager1.ui.theme.Background
import com.stevyson.passwordmanager1.ui.theme.BackgroundElevated
import com.stevyson.passwordmanager1.ui.theme.IconColor
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.SearchBarBorderColor
import com.stevyson.passwordmanager1.ui.theme.Shapes
import com.stevyson.passwordmanager1.ui.theme.TextPrimary


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Add(vm: AddViewModel = hiltViewModel(),
        navController: NavController ,
        drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)) {
    val state by vm.uiState.collectAsState()

    val category = listOf(
        Category.Streaming,
        Category.Social,
        Category.Apps,
        Category.Wallet,
    )


    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Add Password", color = MainTextColor) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Background
            )
        )
    }, content = { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(Shapes.large)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
            ) {
                TableRow(label = "Site name", detailContent = {
                    UnStyledTextField(
                        value = state.siteName,
                        onValueChange = vm::setSiteName,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("e.g Facebook") },
                        arrangement = Arrangement.End,
                        maxLines = 1,
                        textStyle = TextStyle(
                            textAlign = TextAlign.Right,
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                        )
                    )
                })
                Divider(
                    modifier = Modifier.padding(start = 16.dp),
                    thickness = 1.dp,
                    color = SearchBarBorderColor
                )
                TableRow(label = "Email", detailContent = {
                    UnStyledTextField(
                        value = state.email,
                        onValueChange = vm::setEmail,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("e.g abcd123@gmail.com") },
                        arrangement = Arrangement.End,
                        maxLines = 1,
                        textStyle = TextStyle(
                            textAlign = TextAlign.Right,
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                        )
                    )
                })
                Divider(
                    modifier = Modifier.padding(start = 16.dp),
                    thickness = 1.dp,
                    color = SearchBarBorderColor
                )
                TableRow(label = "Category", detailContent = {
                    var categoryMenuOpened by remember {
                        mutableStateOf(false)
                    }
                    TextButton(
                        onClick = { categoryMenuOpened = true }, shape = Shapes.large
                    ) {
                        Text(state.category.name ?: Category.Social.name, color = TextPrimary)
                        DropdownMenu(expanded = categoryMenuOpened,
                            onDismissRequest = { categoryMenuOpened = false }) {
                            category.forEach { category ->
                                DropdownMenuItem(text = { Text(category.name) },
                                    colors = MenuDefaults.itemColors(textColor = TextPrimary),
                                    onClick = {
                                    vm.setCategory(category)
                                    categoryMenuOpened = false
                                })
                            }
                        }
                    }
                })
                Divider(
                    modifier = Modifier.padding(start = 16.dp),
                    thickness = 1.dp,
                    color = SearchBarBorderColor
                )
                TableRow(label = "Password", detailContent = {
                    UnStyledTextField(
                        value = state.password,
                        onValueChange = vm::setPassword,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("") },
                        arrangement = Arrangement.End,
                        maxLines = 1,
                        textStyle = TextStyle(
                            textAlign = TextAlign.Right,
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                        )
                    )
                })
                Divider(
                    modifier = Modifier.padding(start = 16.dp),
                    thickness = 1.dp,
                    color = SearchBarBorderColor
                )


            }
            Button(
                onClick = {
                    vm.savePassword()
                    navController.popBackStack()
                },
                modifier = Modifier.padding(16.dp),
                shape = Shapes.large,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainTextColor
                )

            ) {
                Text("Save Password", color = IconColor)
            }
        }
    })
}
//
//@Preview
//@Composable
//fun PreviewAdd() {
//    PasswordManager1Theme {
//        Add()
//    }
//}
