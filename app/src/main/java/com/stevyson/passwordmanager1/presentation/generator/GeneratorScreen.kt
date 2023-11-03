package com.stevyson.passwordmanager1.presentation.generator

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.stevyson.passwordmanager1.presentation.generator.components.OptionRow
import com.stevyson.passwordmanager1.ui.theme.Background
import com.stevyson.passwordmanager1.ui.theme.BackgroundElevated
import com.stevyson.passwordmanager1.ui.theme.IconColor
import com.stevyson.passwordmanager1.ui.theme.MainTextColor
import com.stevyson.passwordmanager1.ui.theme.SecondaryTextColor
import com.stevyson.passwordmanager1.ui.theme.TextPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneratorScreen(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    navController: NavController,
    vm: GeneratorViewModel = hiltViewModel()
){

    val state by vm.uiState.collectAsState()

    val digitState = remember{ mutableStateOf(state.addDigits)}
    val letterState = remember{ mutableStateOf(state.addLetters)}
    val symbolState = remember{ mutableStateOf(state.addSymbols)}
    val charState = remember{ mutableStateOf(state.addChar)}

    var slider by remember{ mutableStateOf(state.passwordLength) }


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
                        onClick = {
                            navController.popBackStack()
                        },
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
                                .fillMaxWidth()
                                .padding(horizontal = 6.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = vm.generatePassword(state.passwordLength.toInt()),
                                fontSize = 28.sp,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraBold,
                                color = MainTextColor)
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            LinearProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .clip(RoundedCornerShape(16.dp)),
                                progress = state.passwordLength/40f,
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
                                    color = SecondaryTextColor
                                )
                            }
                        }

                    }

                }

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
                            value = slider,
                            onValueChange = { slider = it },
                            valueRange = 0f..40f,
                            onValueChangeFinished = {vm.updateSlider(slider)},
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

                    OptionRow(title = "Digits (e.g. 345)" , isSelected = digitState.value, onClick = {digitState.value = it} )

                    OptionRow(title = "Letters (e.g.Aa)", isSelected = letterState.value, onClick = {letterState.value = it})

                    OptionRow(title ="Symbols (e.g.@$#)" , isSelected = symbolState.value, onClick = { symbolState.value = it })

                    OptionRow(title = "Similar characters (e.g.|/)", isSelected = charState.value, onClick = { charState.value = it })
                    
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(modifier = Modifier.size(width = 330.dp, height = 70.dp),
                    onClick = { /*save password and navigate to password screen*/ },
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

//
//@Preview
//@Composable
//fun PreviewGenerator() {
//    PasswordManager1Theme {
//        GeneratorScreen()
//    }
//}