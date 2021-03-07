/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.CircularProgress
import com.example.androiddevchallenge.ui.theme.Header
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.NumberProgress

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                MakeFrame()
            }
        }
    }
}

var isBusy = false
var originalDuration = 10000L
var second = 1000L
var duration = originalDuration
var progress = mutableStateOf(duration)
var timer: CountDownTimer? = null

fun startCountDown() {
    timer = object : CountDownTimer(duration, second) {
        override fun onTick(millisUntilFinished: Long) {
            progress.value -= second
        }

        override fun onFinish() {
            reset()
        }
    }
    timer?.start()
}

fun stopCountDown() {
    duration = progress.value
    timer?.cancel()
}

fun reset() {
    isBusy = false
    duration = originalDuration
    progress.value = duration
}

@ExperimentalAnimationApi
@Preview
@Composable
fun MakeFrame() = Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceBetween
) {

    Column {
        Header()
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        CircularProgress()
        NumberProgress()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(48.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StartBtn()
        StopBtn()
    }
}

@Composable
fun StartBtn() {
    Button(
        onClick = {
            if(!isBusy){
                startCountDown()
                isBusy = true
            }
        }
    ) {
        Text("START")
    }
}

@Composable
fun StopBtn() {
    Button(
        onClick = {
            if(isBusy){
                isBusy = false
                stopCountDown()
            }
        }
    ) {
        Text("STOP")
    }
}
