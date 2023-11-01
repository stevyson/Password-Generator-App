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
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.stevyson.passwordmanager1.Screen
import com.stevyson.passwordmanager1.domain.model.Password
import com.stevyson.passwordmanager1.presentation.password.PasswordViewModel
import com.stevyson.passwordmanager1.ui.theme.BackgroundElevated
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.TextPrimary

@Composable
fun PasswordListItem(
    vm: PasswordViewModel = hiltViewModel(),
    password: Password,
    navController : NavController,
    modifier: Modifier = Modifier,
    image: Int? = null
){
    var moreMenuOpened by remember {
        mutableStateOf(false)
    }
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
               image?.let { painterResource(id = it) }?.let {
                   Image(
                       painter = it,
                       contentDescription = "icon",
                       modifier = Modifier.size(40.dp)
                   )
               }
           }

           Column(
               horizontalAlignment = Alignment.Start,
               verticalArrangement = Arrangement.spacedBy(3.dp),
               modifier = Modifier
               .padding(end = 30.dp))
           {
               Text(text = password.siteName, color = MainTextColor, fontWeight = FontWeight.Bold)
               Text(text = password.siteEmail, color = TextPrimary)
               Text(text = password.password, color = TextPrimary)
           }
           IconButton(
               onClick = {moreMenuOpened = true},
               modifier = Modifier
                   .align(Alignment.Top)

               ,
           )
           {
               Icon(imageVector = Icons.Rounded.MoreVert,
                   contentDescription = "Delete", tint = TextPrimary)

               DropdownMenu(expanded = moreMenuOpened,
                   onDismissRequest = { moreMenuOpened = false })  {

                       DropdownMenuItem(
                           text = {
                               Text(text = "Edit")
                           },
                           onClick = {
                               navController.navigate(
                                   Screen.AddScreen.route +
                                           "?passwordId=${password.id}"
                               )
                           },
                           trailingIcon = {
                               Icon(imageVector = Icons.Rounded.Edit,
                                   contentDescription = "Edit")
                           }
                       )

                       DropdownMenuItem(
                           text = {
                               Text(text = "Delete")
                           },
                           onClick = {
                               vm.deletePassword(password)
                               moreMenuOpened = false
                           },
                           trailingIcon = {
                               Icon(imageVector = Icons.Rounded.Delete,
                                   contentDescription = "Delete")
                           }
                       )
                   }
               }
           }

       }
    }


//@Preview
//@Composable
//fun PreviewItem() {
//    PasswordManager1Theme {
//        PasswordListItem(
//            title = "Facebook",
//            eMail = "hjhdfhi3456@Gmail.com",
//            password = "********",
//            image = R.drawable.windows_icon
//        )
//    }
//}