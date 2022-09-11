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
package com.cyberwalker.fashionstore.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val dark = Color(0xFF333333)
val gray = Color(0xFFAAAAAA)
val ltgray = Color(0xFFF0F0F0)
val ltgray_dot = Color(0xFFC4C4C4)
val highlight = Color(0xFF6ECB63)


val cardColorYellow = Color(0xFFFFF47D)
val cardColorBlue = Color(0xFFB5DEFF)
val cardColorPeach = Color(0xFFFFADAD)
val cardColorGreen = Color(0xFFC2F784)
val sizeGreen = Color(0xFFE3F5E0)


val Colors.bottomNavbg: Color get() = if (isLight) Color(0xFFFAFAFA) else dark
val Colors.txtColor: Color get() = if (isLight) Color(0xFFFAFAFA) else dark