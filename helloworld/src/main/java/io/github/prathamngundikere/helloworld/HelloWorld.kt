package io.github.prathamngundikere.helloworld

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HelloWorld(modifier: Modifier = Modifier) {
    Text(
        text = "Hello World !!!",
        modifier = modifier
    )
}