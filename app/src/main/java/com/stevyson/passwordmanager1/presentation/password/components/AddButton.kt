package com.stevyson.passwordmanager1.presentation.password.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.stevyson.passwordmanager1.ui.theme.IconColor
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.Shapes

@Composable
fun AddButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        shape = Shapes.medium,
        containerColor = IconColor,
        contentColor = MainTextColor
    ) {
        Icon(Icons.Filled.Add, "Add")
    }
}

@Preview
@Composable
fun PreviewAdd() {
    PasswordManager1Theme {
        AddButton(onClick = {})
    }
}