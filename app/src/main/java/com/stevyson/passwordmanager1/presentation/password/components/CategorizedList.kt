package com.stevyson.passwordmanager1.presentation.password.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.stevyson.passwordmanager1.domain.model.Password
import com.stevyson.passwordmanager1.ui.theme.Background
import com.stevyson.passwordmanager1.ui.theme.MainTextColor

data class CategorizedList(
    val name: String,
    val items: List<Password>
)

@Composable
fun CategoryHeader(
    category: String,
    modifier: Modifier = Modifier
){
    Text(
        text = category,
        fontSize = 20.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.ExtraBold,
        color = MainTextColor,
        modifier = modifier
            .fillMaxWidth()
            .background(Background)
            .padding()
    )
}


@Composable
fun CategoryItem(
    item: Password,
    navController: NavController,
    modifier: Modifier = Modifier
){
    PasswordListItem(password = item, navController = navController )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategorizedLazyColumn(
    navController: NavController,
    categories: List<CategorizedList>,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier){
        categories.forEach{ category ->
            stickyHeader { 
                CategoryHeader(category = category.name.toString())
            }
            items(category.items){ item ->
                CategoryItem(item = item, navController = navController)
            }
        }
    }
}