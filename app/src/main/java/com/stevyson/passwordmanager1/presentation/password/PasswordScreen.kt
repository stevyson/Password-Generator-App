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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stevyson.passwordmanager1.R
import com.stevyson.passwordmanager1.presentation.password.components.AddButton
import com.stevyson.passwordmanager1.presentation.password.components.PasswordListItem
import com.stevyson.passwordmanager1.presentation.password.components.SearchBox
import com.stevyson.passwordmanager1.ui.theme.Background
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordScreen() {

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
                        onClick = { },
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
                Column(modifier = Modifier.scrollable(rememberScrollState(),
                    orientation = Orientation.Vertical)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(text = "Social",
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold,
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(text = "Apps",
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold,
                            color = MainTextColor)
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(13.dp)) {
                        PasswordListItem(
                            title = "Microsoft" ,
                            eMail = "shdkjsa442@gmail.com",
                            password = "********",
                            image = R.drawable.windows_icon)
                    }

                    
                }

            }
        }
    )
}

@Preview
@Composable
fun PreviewPass() {
    PasswordManager1Theme {
        PasswordScreen()
    }
}