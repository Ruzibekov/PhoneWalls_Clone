package uz.ruzibekov.phonewalls_clone.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import uz.ruzibekov.phonewalls_clone.R

val Montserrat = FontFamily(
    Font(R.font.ft_montserrat_regular, FontWeight.Normal),
    Font(R.font.ft_montserrat_medium, FontWeight.Medium),
    Font(R.font.ft_montserrat_semi_bold, FontWeight.SemiBold),
    Font(R.font.ft_montserrat_bold, FontWeight.Bold),
)

val Typography = Typography(

    titleMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold
    ),
    bodyMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium
    ),
    bodySmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)