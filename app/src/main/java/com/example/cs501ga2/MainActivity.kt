package com.example.cs501ga2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cs501ga2.ui.theme.CS501GA2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS501GA2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ParentComposable(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Stateful Parent Composable
@Composable
fun ParentComposable(modifier: Modifier = Modifier) {
    var message by remember { mutableStateOf("Button not clicked yet") }

    ChildComposable(
        text = message,
        onButtonClick = {
            message = "Button was clicked!"
        },
        modifier = modifier
    )
}

//  Stateless Child Composable
@Composable
fun ChildComposable(
    text: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onButtonClick) {
            Text("Click Me")
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun PreviewChild() {
    CS501GA2Theme {
        ChildComposable(
            text = "Preview Text",
            onButtonClick = {}
        )
    }
}
