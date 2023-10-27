package com.stevyson.passwordmanager1.presentation.password.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stevyson.passwordmanager1.R
import com.stevyson.passwordmanager1.ui.theme.BackgroundElevated
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.TextPrimary

@Composable
fun PasswordListItem(
    title: String,
    eMail: String,
    password: String,
    image: Int
){
    Card(

        colors = CardDefaults.cardColors(
            containerColor = BackgroundElevated,
        )
    ) {
       Row(modifier = Modifier
           .fillMaxWidth()
           .padding(top = 13.dp, bottom = 13.dp, end = 10.dp, start = 20.dp),
           horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically)
       {

           Box(contentAlignment = Alignment.Center) {
               Image(
                   painter = painterResource(id = image),
                   contentDescription = "icon",
                   modifier = Modifier.size(40.dp)
               )
           }

           Column(
               horizontalAlignment = Alignment.Start,
               verticalArrangement = Arrangement.spacedBy(3.dp),
               modifier = Modifier
               .padding(end = 30.dp))
           {
               Text(text = title, color = MainTextColor, fontWeight = FontWeight.Bold)
               Text(text = eMail, color = TextPrimary)
               Text(text = password, color = TextPrimary)
           }
           Icon(imageVector = Icons.Rounded.MoreVert,
               contentDescription = "more",
               tint = MainTextColor, modifier = Modifier.align(Alignment.Top))

       }
    }
}

@Preview
@Composable
fun PreviewItem() {
    PasswordManager1Theme {
        PasswordListItem(
            title = "Facebook",
            eMail = "hjhdfhi3456@Gmail.com",
            password = "********",
            image = R.drawable.windows_icon
        )
    }
}