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
package com.cyberwalker.fashionstore.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.fashionstore.R
import com.cyberwalker.fashionstore.ui.theme.dark
import com.cyberwalker.fashionstore.ui.theme.large
import com.cyberwalker.fashionstore.ui.theme.small_caption

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: SplashScreenActions) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPadding ->
        SplashScreenContent(modifier = Modifier.padding(innerPadding), onAction = onAction)
    }
}

@Composable
private fun SplashScreenContent(modifier: Modifier, onAction: (actions: SplashScreenActions) -> Unit) {
    Column(
        modifier = modifier
            .padding(40.dp)
            .fillMaxHeight()
            .semantics { contentDescription = "Splash Screen" }
    ) {
        Text(
            text = "Find and shop your fashion products here.",
            style = MaterialTheme.typography.large.copy(
                shadow = Shadow(
                    color = dark,
                    offset = Offset(0.0f, 4.0f),
                    blurRadius = 5f
                )
            )
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Welcome to our store", style = MaterialTheme.typography.small_caption)
        Image(
            modifier = Modifier
                .defaultMinSize(minWidth = 293.dp, minHeight = 387.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_indicator),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .weight(1F)
                .align(Alignment.CenterHorizontally).clickable {
                    onAction(SplashScreenActions.LoadHome)
                },
            painter = painterResource(id = R.drawable.splash_cta),
            contentDescription = null
        )
    }
}

sealed class SplashScreenActions {
    object LoadHome : SplashScreenActions()
}