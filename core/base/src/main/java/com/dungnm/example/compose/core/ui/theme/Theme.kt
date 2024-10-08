package com.dungnm.example.compose.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dungnm.example.compose.core.constants.Tags

private val DarkColorScheme = darkColorScheme(
    primary = Purple80, secondary = PurpleGrey80, tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40, secondary = PurpleGrey40, tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Immutable
data class CustomColorsPalette(
    val colorTitle: Color = Color.Unspecified,
    val colorDescription: Color = Color.Unspecified,
)

val ExtendTheme = staticCompositionLocalOf { CustomColorsPalette() }
val LocalNavController = compositionLocalOf<NavController> { error("No found NavController") }

val LightCustomColorsPalette = CustomColorsPalette(
    colorDescription = Color(color = 0xFF000000),
    colorTitle = Color(color = 0xFF03A9F4),
)

val DarkCustomColorsPalette = CustomColorsPalette(
    colorDescription = Color(color = 0xFFFFFFFF),
    colorTitle = Color(color = 0xFFFFFFFF),
)

@Composable
fun MainAppTheme(
    theme: String = Tags.THEME_LIGHT,
    content: (@Composable () -> Unit)? = null,
    builder: NavGraphBuilder.(NavHostController) -> Unit = {}
) {
    val colorScheme = when (theme) {
        Tags.THEME_DARK -> DarkColorScheme
        Tags.THEME_LIGHT -> LightColorScheme
        else -> LightColorScheme
    }

    val customColorsPalette = when (theme) {
        Tags.THEME_DARK -> DarkCustomColorsPalette
        Tags.THEME_LIGHT -> LightCustomColorsPalette
        else -> LightCustomColorsPalette
    }

    val navController = rememberNavController()
    CompositionLocalProvider(
        ExtendTheme provides customColorsPalette, // our custom palette,
        LocalNavController provides navController
    ) {
        MaterialTheme(colorScheme = colorScheme, typography = Typography) {
//            val navController = rememberMainNav()
            NavHost(navController = navController, startDestination = "login", builder = {
                builder(navController)
            })
        }
    }
}