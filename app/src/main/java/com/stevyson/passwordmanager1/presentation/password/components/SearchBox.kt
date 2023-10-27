package com.stevyson.passwordmanager1.presentation.password.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.SearchBarBorderColor
import com.stevyson.passwordmanager1.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon",
        tint = MainTextColor) },
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





@Preview
@Composable
fun PreviewSearch() {
    PasswordManager1Theme {
        SearchBox()
    }
}