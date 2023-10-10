package com.myapps.jetpackcomposetest

class BoardModel {


    val blackSquare = R.drawable.blacksquare
    val redSquare = R.drawable.redsquare

    val row0 = listOf(Square(0, 0, redSquare), Square(0, 1, blackSquare), Square(0, 2, redSquare),Square(0, 3, blackSquare), Square(0, 4, redSquare), Square(0, 5, blackSquare), Square(0, 6, redSquare), Square(0, 7, blackSquare))
    val row1 = listOf(Square(1, 0, blackSquare), Square(1, 1, redSquare), Square(1, 2, blackSquare),Square(1, 3, redSquare), Square(1, 4, blackSquare), Square(1, 5, redSquare), Square(1, 6, blackSquare), Square(1, 7, redSquare))
    val row2 = listOf(Square(2, 0, redSquare), Square(2, 1, blackSquare), Square(2, 2, redSquare),Square(2, 3, blackSquare), Square(2, 4, redSquare), Square(2, 5, blackSquare), Square(2, 6, redSquare), Square(2, 7, blackSquare))
    val row3 = listOf(Square(3, 0, blackSquare), Square(3, 1, redSquare), Square(3, 2, blackSquare),Square(3, 3, redSquare), Square(3, 4, blackSquare), Square(3, 5, redSquare), Square(3, 6, blackSquare), Square(3, 7, redSquare))
    val row4 = listOf(Square(4, 0, redSquare), Square(4, 1, blackSquare), Square(4, 2, redSquare),Square(4, 3, blackSquare), Square(4, 4, redSquare), Square(4, 5, blackSquare), Square(4, 6, redSquare), Square(4, 7, blackSquare))
    val row5 = listOf(Square(5, 0, blackSquare), Square(5, 1, redSquare), Square(5, 2, blackSquare),Square(5, 3, redSquare), Square(5, 4, blackSquare), Square(5, 5, redSquare), Square(5, 6, blackSquare), Square(5, 7, redSquare))
    val row6 = listOf(Square(6, 0, redSquare), Square(6, 1, blackSquare), Square(6, 2, redSquare),Square(6, 3, blackSquare), Square(6, 4, redSquare), Square(6, 5, blackSquare), Square(6, 6, redSquare), Square(6, 7, blackSquare))
    val row7 = listOf(Square(7, 0, blackSquare), Square(7, 1, redSquare), Square(7, 2, blackSquare),Square(7, 3, redSquare), Square(7, 4, blackSquare), Square(7, 5, redSquare), Square(7, 6, blackSquare), Square(7, 7, redSquare))

    val originalBoard = listOf<List<Square>>(row0, row1, row2, row3, row4, row5, row6, row7)
    var currentBoard = originalBoard





    //constructor
    class BoardModel() {

    }



    fun unhighlight() {
        for (x in currentBoard)
            for (y in x)
                y.highlighted.value = false
    }


}