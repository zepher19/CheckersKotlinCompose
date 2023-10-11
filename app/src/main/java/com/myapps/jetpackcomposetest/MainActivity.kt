package com.myapps.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue


var boardModel = BoardModel()

var previousHighlightedSquare = boardModel.currentBoard[0][0]


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Board()
        }
    }
}

@Composable
fun Board() {
    val borderWidth = 4.dp

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        //while loops to iterate through only partial board avoiding the padding
        var i = 1
        while (i < 9) {

            var x = boardModel.currentBoard[i]
            Row {

                var j = 1
                while (j < 9) {
                    var y = x[j]
                    val modifierHighlight = Modifier
                        .size(40.dp)
                        .clickable {
                            highlightSquares(y)
                        }
                        .border(BorderStroke(borderWidth, Color.Yellow), RectangleShape)
                        .padding(borderWidth)
                        .clip(RectangleShape)

                    val modifierNormal = Modifier
                        .size(40.dp)
                        .clickable {
                            highlightSquares(y)
                        }

                    val modifierRedSquare = Modifier
                        .size(40.dp)

                    var modifierToUse: Modifier


                    if (y.highlighted.value)
                        modifierToUse = modifierHighlight
                    else if (y.drawableID == R.drawable.redpiece || y.drawableID == R.drawable.whitepiece)
                        modifierToUse = modifierNormal
                    else
                        modifierToUse = modifierRedSquare

                    var drawableID = y.drawableID

                    Image(
                        painter = painterResource(id = drawableID),
                        contentDescription = "draw square",
                        modifierToUse
                    )
                    j++
                }
            }
            i++
        }
    }
}

fun highlightSquares(y: Square) {

    if (previousHighlightedSquare == boardModel.currentBoard[0][0])
        previousHighlightedSquare = y

    //if already highlighted, move instead
    if (y.highlighted.value) {
        movePiece(y)
        return
    }

    boardModel.unhighlight()
    y.highlighted.value = true

    highlightMoves(y)

}

fun movePiece(y: Square) {
    //draw piece in new spot
    boardModel.currentBoard[y.row][y.index].drawableID = previousHighlightedSquare.drawableID

    //delete piece from old spot
    boardModel.currentBoard[previousHighlightedSquare.row][previousHighlightedSquare.index].drawableID = R.drawable.blacksquare


    if (previousHighlightedSquare.row - y.row == 2 || previousHighlightedSquare.row - y.row == -2)
        deletePiece(y)

    //unhighlight after move
    boardModel.unhighlight()

    //reset previous highlighted square
    previousHighlightedSquare = boardModel.currentBoard[0][0]
}

fun deletePiece(y: Square) {
    var rowToDelete = ((previousHighlightedSquare.row + y.row) / 2).absoluteValue
    var indexToDelete = ((previousHighlightedSquare.index + y.index) / 2).absoluteValue

    boardModel.currentBoard[rowToDelete][indexToDelete].drawableID = R.drawable.blacksquare
}

fun highlightMoves(y: Square) {

    //redpiece
    if (y.drawableID == R.drawable.redpiece) {

        var nearEnemy  = false

        //if there is a white piece adjacent
        if (boardModel.currentBoard[y.row - 1][y.index - 1].drawableID == R.drawable.whitepiece) {
            if (boardModel.currentBoard[y.row - 2][y.index - 2].drawableID == R.drawable.blacksquare) {
                boardModel.currentBoard[y.row - 2][y.index - 2].highlighted.value = true
                nearEnemy = true
            }
        }
        if (boardModel.currentBoard[y.row - 1][y.index + 1].drawableID == R.drawable.whitepiece) {
            if (boardModel.currentBoard[y.row - 2][y.index + 2].drawableID == R.drawable.blacksquare) {
                boardModel.currentBoard[y.row - 2][y.index + 2].highlighted.value = true
                nearEnemy = true
            }
        }


        if (!nearEnemy) {
            //highlight adjacent black square
            if (boardModel.currentBoard[y.row - 1][y.index - 1].drawableID == R.drawable.blacksquare)
                boardModel.currentBoard[y.row - 1][y.index - 1].highlighted.value = true
            if (boardModel.currentBoard[y.row - 1][y.index + 1].drawableID == R.drawable.blacksquare)
                boardModel.currentBoard[y.row - 1][y.index + 1].highlighted.value = true
        }
    }

    //whitepiece
    if (y.drawableID == R.drawable.whitepiece) {

        var nearEnemy1  = false

        //if there is a red piece adjacent
        if (boardModel.currentBoard[y.row + 1][y.index - 1].drawableID == R.drawable.redpiece) {
            if (boardModel.currentBoard[y.row + 2][y.index - 2].drawableID == R.drawable.blacksquare) {
                boardModel.currentBoard[y.row + 2][y.index - 2].highlighted.value = true
                nearEnemy1 = true
            }
        }
        if (boardModel.currentBoard[y.row + 1][y.index + 1].drawableID == R.drawable.redpiece) {
            if (boardModel.currentBoard[y.row + 2][y.index + 2].drawableID == R.drawable.blacksquare) {
                boardModel.currentBoard[y.row + 2][y.index + 2].highlighted.value = true
                nearEnemy1 = true
            }
        }


        if (!nearEnemy1) {
            //highlight adjacent black square
            if (boardModel.currentBoard[y.row + 1][y.index - 1].drawableID == R.drawable.blacksquare)
                boardModel.currentBoard[y.row + 1][y.index - 1].highlighted.value = true
            if (boardModel.currentBoard[y.row + 1][y.index + 1].drawableID == R.drawable.blacksquare)
                boardModel.currentBoard[y.row + 1][y.index + 1].highlighted.value = true
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BoardPreview() {
    Board()
}