package com.stevyson.passwordmanager1.presentation.generator.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stevyson.passwordmanager1.ui.theme.BackgroundElevated
import com.stevyson.passwordmanager1.ui.theme.IconColor
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.SecondaryTextColor
import com.stevyson.passwordmanager1.ui.theme.Shapes

@Composable
fun DisplayCard(){

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding( vertical = 10.dp)

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
                    Icon(imageVector = Icons.Rounded.Refresh,
                        contentDescription = "Retry",
                    tint = MainTextColor)
                }
                Row(
                    modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "GSOJGLL04!90",
                        fontSize = 28.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.ExtraBold,
                        color = MainTextColor)
                }

                Box(
                    contentAlignment = Alignment.Center
                ){
                    Canvas(modifier = Modifier.size(70.dp)){
                        drawLine(
                            color = MainTextColor,
                            start = Offset(-300f,50f),
                            end = Offset(500f,50f),
                            strokeWidth = 10f,
                            cap = StrokeCap.Round
                        )
                    }
                    Canvas(modifier = Modifier.size(70.dp)){
                        drawLine(
                            color = IconColor,
                            start = Offset(-300f,50f),
                            end = Offset(270f,50f),
                            strokeWidth = 10f,
                            cap = StrokeCap.Round
                        )

                    }
                    Spacer(modifier = Modifier.height(20.dp))
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