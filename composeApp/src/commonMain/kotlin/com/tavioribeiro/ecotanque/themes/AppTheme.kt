package com.tavioribeiro.ecotanque.themes

import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp




val AppColors = lightColors(
    primary = Color(0xFFB5F53D), // Cor primária (ex: azul mais escuro)
    primaryVariant = Color(0xFF88A05D), // Variante da cor primária (ex: azul mais claro)
    secondary = Color(0xFFA1CA54), // Cor secundária (ex: ciano)
    secondaryVariant = Color(0xFF6B7558), // Variante da cor secundária
    background = Color(0xFF0D0D0D), // Cor de fundo padrão
    surface = Color(0xFF262626), // Cor de superfícies (cards, dialogs, etc.)
    error = Color(0xFFF53232), // Cor de erro
    onPrimary = Color(0xFF262626), // Cor do texto/ícones sobre a cor primária
    onSecondary = Color(0xFF0D0D0D), // Cor do texto/ícones sobre a cor secundária
    onBackground = Color(0xFFBFBFBF), // Cor do texto/ícones sobre o fundo
    onSurface = Color(0xFFBFBFBF), // Cor do texto/ícones sobre superfícies
    onError = Color(0xFF0D0D0D) // Cor do texto/ícones sobre a cor de erro
)



val AppTypography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 26.sp,
        color = Color(0xFF6B7558)
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color(0xFF6B7558)
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Color(0xFF6B7558)
    ),
)