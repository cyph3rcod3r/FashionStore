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
package com.cyberwalker.fashionstore.detail


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.fashionstore.R
import com.cyberwalker.fashionstore.dump.vertical
import com.cyberwalker.fashionstore.ui.theme.*

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: DetailScreenActions) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPadding ->
        DetailScreenContent(modifier = Modifier.padding(innerPadding), onAction = onAction)
    }
}

@Composable
private fun DetailScreenContent(
    modifier: Modifier,
    onAction: (actions: DetailScreenActions) -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = 40.dp)
            .fillMaxHeight()
            .semantics { contentDescription = "Detail Screen" }
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        ImageBox(onAction = onAction)
        Spacer(modifier = Modifier.size(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 228.dp)
        ) {
            TabRow()
            Spacer(modifier = Modifier.size(16.dp))
            ProductInfo()
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Size", style = MaterialTheme.typography.medium_18)
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = sizeGreen, shape = RoundedCornerShape(12.dp))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "S", style = MaterialTheme.typography.medium_18_bold.copy(dark))
            }
            Box(modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = sizeGreen, shape = RoundedCornerShape(12.dp))
                .clickable { }, contentAlignment = Alignment.Center) {
                Text(text = "M", style = MaterialTheme.typography.medium_18_bold.copy(dark))
            }
            Box(modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = highlight, shape = RoundedCornerShape(12.dp))
                .clickable { }, contentAlignment = Alignment.Center) {
                Text(text = "L", style = MaterialTheme.typography.medium_18_bold.copy(color = Color.White))
            }
            Box(modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = sizeGreen, shape = RoundedCornerShape(12.dp))
                .clickable { }, contentAlignment = Alignment.Center) {
                Text(text = "XL", style = MaterialTheme.typography.medium_18_bold.copy(dark))
            }
        }
        Spacer(modifier = Modifier.weight(1F))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
           Column {
               Text(text = "Price", style = MaterialTheme.typography.caption.copy(gray))
               Spacer(modifier = Modifier.size(4.dp))
               Text(text = "₹1284", style = MaterialTheme.typography.medium_18)
           }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = highlight),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .widthIn(170.dp)
                    .defaultMinSize(minHeight = 40.dp)
            ) {
                Text(
                    text = "Add To Cart",
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    fontFamily = poppinsFamily,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Composable
fun ProductInfo() {
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Sbm T-Shirt", style = MaterialTheme.typography.medium_18)
            Row {
                Text(text = "5/5", style = MaterialTheme.typography.medium_18)
                Spacer(modifier = Modifier.size(8.dp))
                Image(painter = painterResource(id = R.drawable.icstar), contentDescription = null)
            }
        }
        Text(text = "Modern Peach", style = MaterialTheme.typography.small_caption2)
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = textWithLink,
            style = MaterialTheme.typography.small_caption.copy(color = gray)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            buildAnnotatedString {
                productInfo.forEach {
                    withStyle(style = paragraphStyle) {
                        append(bullet)
                        append("\t\t")
                        append(it)
                    }
                }
            },
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.small_caption2
        )
    }
}

val textWithLink = buildAnnotatedString {
    append("Lorem ipsum dolor, sit amet consectetur adipisicing elit. Tenetur, sit fuga? Cum optio fugit ")

    pushStringAnnotation(tag = "See more", annotation = "https://google.com/")
    withStyle(style = SpanStyle(color = Purple700)) {
        append("See more")
    }
    pop()
}

val bullet = "\u2022"
val productInfo = listOf(
    "Dolor sit amet",
    "Lorem ipsum",
)
val paragraphStyle = ParagraphStyle(textIndent = TextIndent())

@Composable
private fun ImageBox(onAction: (actions: DetailScreenActions) -> Unit) {
    Box(
        modifier = Modifier
            .defaultMinSize(minHeight = 310.dp)
            .fillMaxWidth()
            .background(color = cardColorBlue, shape = RoundedCornerShape(16.dp))
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 16.dp)
                .clickable { onAction(DetailScreenActions.Back) },
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 16.dp, top = 16.dp),
            painter = painterResource(id = R.drawable.ic_heart_filled),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .defaultMinSize(minWidth = 287.dp, minHeight = 335.dp)
                .align(Alignment.BottomCenter),
            painter = painterResource(id = R.drawable.ic_girl),
            contentDescription = null
        )
    }
}

@Composable
private fun TabRow() {
    Row(
        modifier = Modifier
            .vertical()
            .rotate(-90F), verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .size(30.dp)
                .background(color = cardColorBlue, shape = CircleShape)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Spacer(
            modifier = Modifier
                .size(30.dp)
                .background(color = cardColorGreen, shape = CircleShape)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(color = cardColorPeach, shape = CircleShape)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .rotate(90F),
                painter = painterResource(id = R.drawable.ic_tick),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Spacer(
            modifier = Modifier
                .size(30.dp)
                .background(color = cardColorYellow, shape = CircleShape)
        )
    }
}

sealed class DetailScreenActions {
    object Back : DetailScreenActions()
}