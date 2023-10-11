package com.myapps.jetpackcomposetest

class BoardModel {


    val blackSquare = R.drawable.blacksquare
    val redSquare = R.drawable.redsquare
    val redPiece = R.drawable.redpiece
    val whitePiece = R.drawable.whitepiece

    val row0 = listOf(Square(0, 0, 0, '0'), Square(0, 1, redSquare, '0'), Square(0, 2, whitePiece, 'w'), Square(0, 3, redSquare, '0'),Square(0, 4, whitePiece, 'w'), Square(0, 5, redSquare, '0'), Square(0, 6, whitePiece, 'w'), Square(0, 7, redSquare, '0'), Square(0, 8, whitePiece, 'w'), Square(0, 9, 0, '0'))
    val row1 = listOf(Square(1, 0, 0, '0'), Square(1, 1, redSquare, '0'), Square(1, 2, whitePiece, 'w'), Square(1, 3, redSquare, '0'),Square(1, 4, whitePiece, 'w'), Square(1, 5, redSquare, '0'), Square(1, 6, whitePiece, 'w'), Square(1, 7, redSquare, '0'), Square(1, 8, whitePiece, 'w'), Square(1, 9, 0, '0'))
    val row2 = listOf(Square(2, 0, 0, '0'), Square(2, 1, whitePiece, 'w'), Square(2, 2, redSquare, '0'), Square(2, 3, whitePiece, 'w'),Square(2, 4, redSquare, '0'), Square(2, 5, whitePiece, 'w'), Square(2, 6, redSquare, '0'), Square(2, 7, whitePiece, 'w'), Square(2, 8, redSquare, '0'), Square(2, 9, 0, '0'))
    val row3 = listOf(Square(3, 0, 0, '0'), Square(3, 1, redSquare, '0'), Square(3, 2, whitePiece, 'w'), Square(3, 3, redSquare, '0'),Square(3, 4, whitePiece, 'w'), Square(3, 5, redSquare, '0'), Square(3, 6, whitePiece, 'w'), Square(3, 7, redSquare, '0'), Square(3, 8, whitePiece, 'w'), Square(3, 9, 0, '0'))
    val row4 = listOf(Square(4, 0, 0, '0'), Square(4, 1, blackSquare, 'b'), Square(4, 2, redSquare, '0'), Square(4, 3, blackSquare, 'b'),Square(4, 4, redSquare, '0'), Square(4, 5, blackSquare, 'b'), Square(4, 6, redSquare, '0'), Square(4, 7, blackSquare, 'b'), Square(4, 8, redSquare, '0'), Square(4, 9, 0, '0'))
    val row5 = listOf(Square(5, 0, 0, '0'), Square(5, 1, redSquare, '0'), Square(5, 2, blackSquare, 'b'), Square(5, 3, redSquare, '0'),Square(5, 4, blackSquare, 'b'), Square(5, 5, redSquare, '0'), Square(5, 6, blackSquare, 'b'), Square(5, 7, redSquare, '0'), Square(5, 8, blackSquare, 'b'), Square(5, 9, 0, '0'))
    val row6 = listOf(Square(6, 0, 0, '0'), Square(6, 1, redPiece, 'r'), Square(6, 2, redSquare, '0'), Square(6, 3, redPiece, 'r'),Square(6, 4, redSquare, '0'), Square(6, 5, redPiece, 'r'), Square(6, 6, redSquare, '0'), Square(6, 7, redPiece, 'r'), Square(6, 8, redSquare, '0'), Square(6, 9, 0, '0'))
    val row7 = listOf(Square(7, 0, 0, '0'), Square(7, 1, redSquare, '0'), Square(7, 2, redPiece, 'r'), Square(7, 3, redSquare, '0'),Square(7, 4, redPiece, 'r'), Square(7, 5, redSquare, '0'), Square(7, 6, redPiece, 'r'), Square(7, 7, redSquare, '0'), Square(7, 8, redPiece, 'r'), Square(7, 9, 0, '0'))
    val row8 = listOf(Square(8, 0, 0, '0'), Square(8, 1, redPiece, 'r'), Square(8, 2, redSquare, 'o'), Square(8, 3, redPiece, 'r'),Square(8, 4, redSquare, '0'), Square(8, 5, redPiece, 'r'), Square(8, 6, redSquare, '0'), Square(8, 7, redPiece, 'r'), Square(8, 8, redSquare, '0'), Square(8, 9, 0, '0'))
    val row9 = listOf(Square(9, 0, 0, '0'), Square(9, 1, redPiece, 'r'), Square(9, 2, redSquare, 'o'), Square(9, 3, redPiece, 'r'),Square(9, 4, redSquare, '0'), Square(9, 5, redPiece, 'r'), Square(9, 6, redSquare, '0'), Square(9, 7, redPiece, 'r'), Square(9, 8, redSquare, '0'), Square(9, 9, 0, '0'))


    val originalBoard = listOf<List<Square>>(row0, row1, row2, row3, row4, row5, row6, row7, row8, row9)
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