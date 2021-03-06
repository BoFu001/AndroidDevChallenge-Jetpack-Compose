package com.example.androiddevchallenge.ui.theme
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.progress

@Composable
fun CircularProgress() {

    val progress = remember { progress }
    val value = progress.value.toFloat() / 10000 * -1

    val animatedProgress = animateFloatAsState(
        targetValue = value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    CircularProgressIndicator(
        progress = animatedProgress,
        Modifier.size(200.dp),
        strokeWidth = 8.dp
    )
}

@Composable
fun NumberProgress(){

    val progress = remember { progress }
    val num = progress.value/1000

    Text(
        text = num.toString(),
        fontSize = 60.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}