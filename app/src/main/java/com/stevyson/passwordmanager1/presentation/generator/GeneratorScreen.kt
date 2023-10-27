package com.stevyson.passwordmanager1.presentation.generator

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stevyson.passwordmanager1.presentation.generator.components.DisplayCard
import com.stevyson.passwordmanager1.presentation.generator.components.LengthSlider
import com.stevyson.passwordmanager1.presentation.generator.components.OptionRow
import com.stevyson.passwordmanager1.ui.theme.Background
import com.stevyson.passwordmanager1.ui.theme.IconColor
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.PasswordManager1Theme
import com.stevyson.passwordmanager1.ui.theme.Shapes
import com.stevyson.passwordmanager1.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneratorScreen(){

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Password Generator",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.ExtraBold,
                color = MainTextColor) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Background
                ),
                navigationIcon = {
                    Surface(
                        onClick = {  },
                        color = Color.Transparent,
                    ) {
                        Row(modifier = Modifier.padding(vertical = 10.dp)) {
                            Icon(
                                Icons.Rounded.ArrowBack,
                                contentDescription = "Settings",
                                tint = MainTextColor
                            )
                        }
                    }
                })
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .background(Background)
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp)
                    .fillMaxSize()
                    ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DisplayCard()

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(text = "Options",
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold,
                            color = MainTextColor)
                    }

                    LengthSlider()

                    OptionRow(title = "Digits (e.g. 345)" , isSelected = true )

                    OptionRow(title = "Letters (e.g.Aa)", isSelected = true)

                    OptionRow(title ="Symbols (e.g.@$#)" , isSelected = true)

                    OptionRow(title = "Similar characters (e.g.|/)", isSelected = false)
                    
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(modifier = Modifier.size(width = 330.dp, height = 70.dp),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MainTextColor
                    )
                ){
                    Text(text = "Copy password", color = IconColor, fontSize = 20.sp)
                }


            }
        }
    )

}


@Preview
@Composable
fun PreviewGenerator() {
    PasswordManager1Theme {
        GeneratorScreen()
    }
}