package com.stevyson.passwordmanager1.presentation.homescreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.SearchBarBorderColor
import com.stevyson.passwordmanager1.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearchBox(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "searchIcon",
            tint = MainTextColor, modifier = Modifier.size(40.dp)) },
        onValueChange = {
            text = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MainTextColor,
            focusedBorderColor = SearchBarBorderColor,
            unfocusedBorderColor = SearchBarBorderColor,
            placeholderColor = MainTextColor,
            disabledBorderColor = SearchBarBorderColor,
            disabledTextColor = MainTextColor,
            disabledLeadingIconColor = MainTextColor
        ),
        shape = Shapes.medium,
        placeholder = { Text(text = "Search", color = MainTextColor) },
    )

}
