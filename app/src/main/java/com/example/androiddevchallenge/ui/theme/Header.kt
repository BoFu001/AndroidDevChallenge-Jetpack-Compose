package com.example.androiddevchallenge.ui.theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

@Composable
fun Header(){

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().padding(0.dp,32.dp,0.dp,4.dp)
    ){
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(id = R.drawable.ic_hourglass),
            contentDescription = "hourglass"
        )
    }

    Text(
        text = " COUNTDOWN",
        fontSize = 26.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}