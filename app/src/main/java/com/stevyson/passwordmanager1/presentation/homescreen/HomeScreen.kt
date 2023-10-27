package com.stevyson.passwordmanager1.presentation.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stevyson.passwordmanager1.R
import com.stevyson.passwordmanager1.presentation.homescreen.components.HomeSearchBox
import com.stevyson.passwordmanager1.presentation.homescreen.components.MyAccountsTab
import com.stevyson.passwordmanager1.presentation.password.components.PasswordListItem
import com.stevyson.passwordmanager1.ui.theme.Background
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.SearchBarBorderColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
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
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "menu",
                            tint = SearchBarBorderColor,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
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
                scrollBehavior = scrollBehavior
            )
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
                        .padding(vertical = 3.dp),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(text = "Welcome Back",
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Medium,
                        color = MainTextColor)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(text = "Sammy Waghat",
                        fontSize = 30.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.ExtraBold,
                        color = MainTextColor)
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
                    Text(text = "My Accounts",
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Medium,
                        color = MainTextColor)
                }

                MyAccountsTab()


                Column(modifier = Modifier.scrollable(
                    rememberScrollState(),
                    orientation = Orientation.Vertical)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(text = "Latest Account",
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Medium,
                            color = MainTextColor)
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(13.dp)) {
                        PasswordListItem(
                            title = "Facebook" ,
                            eMail = "shdkjsa442@gmail.com",
                            password = "********",
                            image = R.drawable.facebook_logo_icon)

                        PasswordListItem(
                            title = "Linkedin" ,
                            eMail = "shdkjsa442@gmail.com",
                            password = "********",
                            image = R.drawable.linkedin_logo_icon)

                        PasswordListItem(
                            title = "Twitter" ,
                            eMail = "shdkjsa442@gmail.com",
                            password = "********",
                            image = R.drawable.twitter_icon)

                    }

                }

            }
        }
    )
}



@Preview
@Composable
fun PreviewHome() {
    PasswordManager1Theme {
        HomeScreen()
    }
}