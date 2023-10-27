package com.stevyson.passwordmanager1.presentation.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stevyson.passwordmanager1.R
import com.stevyson.passwordmanager1.ui.theme.BackgroundElevated
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.SecondaryTextColor
import com.stevyson.passwordmanager1.ui.theme.Shapes

@Composable
fun MyAccountsTab(){
    Row(
        modifier = Modifier
            .padding(vertical = 25.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Surface(
                shape = Shapes.large,
                modifier = Modifier.size(70.dp) ,
                color = BackgroundElevated

            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                    contentDescription = "icon",
                )
            }
            Text(text = "Streaming",
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = MainTextColor)
            Text(text = "5 passwords",
                fontSize = 10.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = SecondaryTextColor)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Surface(
                shape = Shapes.large,
                modifier = Modifier.size(70.dp) ,
                color = BackgroundElevated

            ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "icon",
                modifier = Modifier.size(25.dp)
            )
            }
            Text(text = "Social",
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = MainTextColor)
            Text(text = "10 passwords",
                fontSize = 10.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = SecondaryTextColor)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Surface(
                shape = Shapes.large,
                modifier = Modifier.size(70.dp) ,
                color = BackgroundElevated

            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_grid_view_24),
                    contentDescription = "icon",
                    modifier = Modifier.size(25.dp)
                )
            }
            Text(text = "Apps",
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = MainTextColor)
            Text(text = "2 passwords",
                fontSize = 10.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = SecondaryTextColor)

        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Surface(
                shape = Shapes.large,
                modifier = Modifier.size(70.dp) ,
                color = BackgroundElevated

            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_balance_wallet_24),
                    contentDescription = "icon",
                    modifier = Modifier.size(25.dp),

                )
            }
            Text(text = "Wallet",
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = MainTextColor
            )
            Text(text = "3 passwords",
                fontSize = 10.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = SecondaryTextColor)


        }

    }
}

@Preview
@Composable
fun PreviewTab() {
    PasswordManager1Theme {
        MyAccountsTab()
    }
}