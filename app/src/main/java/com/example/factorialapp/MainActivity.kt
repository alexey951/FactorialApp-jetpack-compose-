package com.example.factorialapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.factorialapp.ui.theme.FactorialAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Factorial()
        }
    }
}

@Composable
fun Factorial() {
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(factorialAsString(0)) }

   Column (
        modifier = Modifier
            .background(Color.LightGray).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ){
       Text(
           text = text,
           modifier = Modifier.clickable {
               expanded = true
           },
           style = MaterialTheme.typography.h2
       )
       DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
           for (n in 0 until 21) {
               DropdownMenuItem(onClick = {
                   expanded = false
                   text = factorialAsString(n)
               }) {
                   Text(text = "${n.toString()}!")
               }
           }
       }
       Button(onClick = { text = factorialAsString(0) }) {
           Text(text = "RESET")
       }
   }
}

fun factorialAsString(n: Int): String {
    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    return "$n! = $result"
}

