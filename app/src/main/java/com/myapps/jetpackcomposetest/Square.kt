package com.myapps.jetpackcomposetest

import androidx.compose.runtime.mutableStateOf


class Square(var row: Int, var index: Int, var drawableID: Int, var pieceColor: Char) {

    var highlighted = mutableStateOf(false)
}
