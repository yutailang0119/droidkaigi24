package com.jetbrains.workshop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var text by remember { mutableStateOf("") }
        var loadedText by remember { mutableStateOf("") }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(value = text, onValueChange = { text = it })
            Button(onClick = {
                saveString("my-key", text)
                println("stored")
            }) {
                Text("store text")
            }
            Button(onClick = {
                loadString("my-key").let {
                    println("restored: $it")
                    loadedText = it
                }
            }) {
                Text("restore text")
            }
            Text("restored text: $loadedText")
        }
    }
}