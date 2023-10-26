package com.stevyson.passwordmanager1.presentation.generator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.stevyson.passwordmanager1.ui.theme.IconColor
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.SecondaryTextColor
import com.stevyson.passwordmanager1.ui.theme.TextPrimary

@Composable
fun OptionRow(
    title: String,
    isSelected: Boolean
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title,
            fontSize = 17.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium,
            color = MainTextColor)

        Switch(
            checked = isSelected,
            onCheckedChange = {!isSelected},
            colors = SwitchDefaults.colors(
                checkedThumbColor = MainTextColor,
                checkedTrackColor = IconColor,
                uncheckedThumbColor = MainTextColor,
                uncheckedTrackColor = SecondaryTextColor,
            )
        )
    }
}


@Preview
@Composable
fun PreviewOpRow() {
    PasswordManager1Theme {
        OptionRow(title = "numbers", isSelected = true)
    }
}