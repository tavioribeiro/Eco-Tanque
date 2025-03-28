package com.tavioribeiro.ecotanque

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tavioribeiro.ecotanque.themes.AppColors
import com.tavioribeiro.ecotanque.themes.AppTypography
import ecotanque.composeapp.generated.resources.Res
import ecotanque.composeapp.generated.resources.icon_calculator
import ecotanque.composeapp.generated.resources.icon_car
import ecotanque.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource


@Composable
fun AppCompose() {
    var selectedItem by remember { mutableStateOf("Calculadora") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        bottomBar = {
            CustomNavigationBar(
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
            ) {
                CustomNavigationBarItem(
                    selected = selectedItem == "Calculadora",
                    onClick = { selectedItem = "Calculadora" },
                    icon = {
                        Icon(
                            painter = painterResource(Res.drawable.icon_calculator),
                            contentDescription = "Calculadora", tint = Color.White,
                            modifier = Modifier
                                .size(22.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Calculadora",
                            color = Color.White,
                            style = MaterialTheme.typography.button,
                            modifier = Modifier
                                    .padding(0.dp, 5.dp, 0.dp, 0.dp)
                        )
                    }
                )
                CustomNavigationBarItem(
                    selected = selectedItem == "Veículos",
                    onClick = { selectedItem = "Veículos" },
                    icon = {
                        Icon(
                            painter = painterResource(Res.drawable.icon_car),
                            contentDescription = "Veículos", tint = Color.White,
                            modifier = Modifier
                                .size(22.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Veículos",
                            color = Color.White,
                            style = MaterialTheme.typography.button,
                            modifier = Modifier
                                .padding(0.dp, 5.dp, 0.dp, 0.dp)
                        )
                    }
                )
            }
        },
        topBar = {
            TopAppBar()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            when (selectedItem) {
                "Calculadora" -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    DynamicButton(
                        text = "Gray Light",
                        onClick = { println("Gray Light Clicked") },
                        buttonBackgroundColor = Color(0xFFF2F2F7),
                        labelColor = Color.Black,
                        iconColor = Color.Black,
                        icon = Icons.Filled.ArrowForward // Example icon
                    )

                    DynamicButton(
                        text = "Gray Dark",
                        onClick = { println("Gray Dark Clicked") },
                        buttonBackgroundColor = Color(0xFF2C2C2E),
                        labelColor = Color.White,
                        iconColor = Color.White,
                        icon = Icons.Filled.ArrowBack // Example icon
                    )

                    DynamicButton(
                        text = "Plain Light No Icon", // Example without icon
                        onClick = { println("Plain Light Clicked") },
                        buttonBackgroundColor = Color.Transparent, // For Plain, button background is transparent
                        labelColor = Color(0xFF007AFF),
                        iconColor = Color(0xFF007AFF),
                        icon = null // No icon provided
                    )
                    DynamicButton(
                        text = "Plain Dark",
                        onClick = { println("Plain Dark Clicked") },
                        buttonBackgroundColor = Color.Transparent, // For Plain, button background is transparent
                        labelColor = Color(0xFF0A84FF),
                        iconColor = Color(0xFF0A84FF),
                        icon = Icons.Filled.ArrowForward // Example icon
                    )
                }
           // Text("Tela da Calculadora", color = Color.White)
                "Veículos" -> Text("Tela de Veículos", color = Color.White)
            }
        }
    }
}

@Composable
fun App() {
    MaterialTheme(
        colors = AppColors,
        typography = AppTypography,
        content = {
            AppCompose()
        }
    )
}

@Composable
fun CustomNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}

@Composable
fun CustomNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .clickable(onClick = onClick)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(if (selected) Color(0xFF555555) else Color.Transparent)
                .padding(4.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                icon()
                label()
            }
        }
    }
}


@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 30.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 5.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(38.dp)
                    .padding(7.dp, 0.dp, 8.dp, 0.dp)
            )
            Text(
                style = MaterialTheme.typography.h1,
                text = "Eco Tanque",
                color = Color.White,
            )
        }
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}



@Composable
fun DynamicButton(
    text: String,
    onClick: () -> Unit,
    buttonBackgroundColor: Color,
    labelColor: Color,
    iconColor: Color,
    icon: ImageVector? = null // Make icon parameter nullable and optional
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(114.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonBackgroundColor),
        shape = RoundedCornerShape(14.dp),
        contentPadding = PaddingValues(0.dp) // Reset default button padding
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon (Conditionally display if icon is provided, otherwise no icon)
            if (icon != null) {
                Icon(
                    imageVector = icon, // Use the dynamic icon parameter
                    contentDescription = "Icone",
                    modifier = Modifier
                        .size(20.dp),
                    tint = iconColor // Dynamic Icon Color
                )
                Spacer(modifier = Modifier.width(10.dp)) // Add spacer only if icon is present
            }

            Text(
                text = text,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif, // Approximation for SF Pro Text/Display
                    fontWeight = FontWeight.Bold, // Body/Bold - 600
                    fontSize = 17.sp, // Body/Bold - 17px
                    lineHeight = 22.sp, // Body/Bold - 22px
                    letterSpacing = (-0.408).sp, // Body/Bold - -0.408px
                    color = labelColor, // Dynamic Label Color
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .width(44.dp)
                    .height(22.dp)
            )
        }
    }
}
