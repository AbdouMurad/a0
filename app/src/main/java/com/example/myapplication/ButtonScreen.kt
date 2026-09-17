package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Header(
    id: String,
    ccid: String,
    modifier : Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(32.dp).height(32.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "  ID: " + id,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "  CCID: " + ccid,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
@Composable
fun ButtonScreen(
    modifier : Modifier = Modifier
) {
    var buttonClickCounter by remember { mutableIntStateOf(0) }
    var displayString by remember { mutableStateOf("Should we go?") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        fun randomNumber(odd: Int) {
            val randomNum = (1..odd).random();
            if (randomNum == 1) {
                displayString = "Yes"
            }
            else {
                displayString = "No"
            }
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = displayString,
                fontSize = 32.sp
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                modifier = modifier,
                onClick = {
                    randomNumber(2)
                    ++buttonClickCounter
                }
            ) {
                Text("Ok!")
            }
            Spacer(modifier = modifier.width(8.dp))
            Button(
                modifier = modifier,
                onClick = {
                    randomNumber(4)
                    ++buttonClickCounter
                }
            ) {
                Text("Meh")
            }
            Spacer(modifier = modifier.width(8.dp))
            Button(
                modifier = modifier,
                onClick = {
                    randomNumber(10)
                    ++buttonClickCounter
                }
            ) {
                Text("Nah")
            }
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Clicks: " + buttonClickCounter)
        }

    }
}