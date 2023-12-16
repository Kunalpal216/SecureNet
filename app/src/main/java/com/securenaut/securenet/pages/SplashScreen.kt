package com.securenaut.securenet.pages

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.securenaut.securenet.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 2f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 1200,
                easing = {
                    OvershootInterpolator(6f).getInterpolation(it)
                }))
        // Customize the delay time
        delay(1500L)
        navController.navigate("home")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        // Change the logo
        Image(painter = painterResource(id = R.drawable.splash3),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}