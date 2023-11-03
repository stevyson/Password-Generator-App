package com.stevyson.passwordmanager1.presentation.generator.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stevyson.passwordmanager1.presentation.generator.GeneratorViewModel
import com.stevyson.passwordmanager1.ui.theme.BackgroundElevated
import com.stevyson.passwordmanager1.ui.theme.IconColor
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.SecondaryTextColor

@Composable
fun DisplayCard(
    vm: GeneratorViewModel = hiltViewModel()
){ val state by vm.uiState.collectAsState()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)

            ,
            shape = CardDefaults.elevatedShape,
            colors = CardDefaults.cardColors(BackgroundElevated),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Row(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement =Arrangement.End) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.Top)
                    ){
                        Icon(imageVector = Icons.Rounded.Refresh,
                            contentDescription = "Redo", tint = MainTextColor
                        )
                    }
                }
                Row(
                    modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "",
                        fontSize = 28.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.ExtraBold,
                        color = MainTextColor)
                }

                Spacer(modifier = Modifier.height(15.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth(0.7f).clip(RoundedCornerShape(16.dp)),
                        progress = 0.4f,
                        color = IconColor,
                        trackColor = MainTextColor
                    )
//
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Lets make this password stronger",
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold,
                            color = SecondaryTextColor)
                    }
                }

            }

        }

}



@Preview
@Composable
fun PreviewCard() {
    PasswordManager1Theme {
        DisplayCard()
    }
}