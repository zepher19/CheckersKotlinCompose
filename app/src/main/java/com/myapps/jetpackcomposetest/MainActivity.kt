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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


var boardModel = BoardModel()


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

        for (x in boardModel.currentBoard)

            Row {
            for (y in x) {

                val modifierHighlight = Modifier
                    .size(40.dp)
                    .clickable {
                        boardModel.unhighlight()
                        y.highlighted.value = true
                    }
                    .border(BorderStroke(borderWidth, Color.Yellow), RectangleShape)
                    .padding(borderWidth)
                    .clip(RectangleShape)


                val modifierNormal = Modifier
                    .size(40.dp)
                    .clickable {
                        boardModel.unhighlight()
                        y.highlighted.value = true
                    }

                val modifierRedSquare = Modifier
                    .size(40.dp)

                var modifierToUse: Modifier


                if (y.highlighted.value)
                    modifierToUse = modifierHighlight
                else if (y.drawableID == R.drawable.blacksquare)
                    modifierToUse = modifierNormal
                else
                    modifierToUse = modifierRedSquare


                if (y.drawableID == R.drawable.blacksquare)
                    Image(
                        painter = painterResource(id = R.drawable.blacksquare),
                        contentDescription = "Black Square",
                        modifierToUse
                    )
                else
                    Image(
                        painter = painterResource(id = R.drawable.redsquare),
                        contentDescription = "Red Square",
                        modifierToUse
                    )
            }
        }
    }
}


fun highlight() {

}


@Preview(showBackground = true)
@Composable
fun BoardPreview() {
    Board()
}