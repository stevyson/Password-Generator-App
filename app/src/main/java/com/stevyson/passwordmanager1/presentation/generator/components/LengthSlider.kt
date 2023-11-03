package com.stevyson.passwordmanager1.presentation.generator.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stevyson.passwordmanager1.ui.theme.IconColor
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.TextPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LengthSlider(
   sliderPositions: SliderPositions
){
    var sliderPosition by remember { mutableStateOf(20f) }
    Column() {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Length",
                fontSize = 17.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = MainTextColor
            )

        }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..40f,
            interactionSource = MutableInteractionSource(),
            thumb = {SliderDefaults.Thumb(colors = SliderDefaults.colors(
                thumbColor = MainTextColor,
                activeTrackColor = IconColor
            ) ,
                interactionSource = MutableInteractionSource(),
                thumbSize = DpSize(40.dp,40.dp) )},
            colors = SliderDefaults.colors(
                thumbColor = MainTextColor,
                activeTrackColor = IconColor,
                inactiveTrackColor = MainTextColor,
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "0",
                fontSize = 17.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = TextPrimary
            )

            Text(text = "40",
                fontSize = 17.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                color = TextPrimary
            )

        }
    }
}


//
//@Preview
//@Composable
//fun PreviewSlider() {
//    PasswordManager1Theme {
//        LengthSlider()
//    }
//}