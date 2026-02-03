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
            ParentComposable()
        }
    }
}

// Stateful Parent Composable
@Composable
fun ParentComposable(modifier: Modifier = Modifier) {
    // two state booleans
    var isDarkMode by remember { mutableStateOf(false) }
    var wasClicked by remember { mutableStateOf(false) }

    val message = if (wasClicked) "Button was clicked!" else "Button not clicked yet"
    val buttonText = if (isDarkMode) "Switch to Light Mode" else "Switch to Dark Mode"

    // we change the theme on button presses too!!!
    CS501GA2Theme(darkTheme = isDarkMode) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ChildComposable(
                text = message,
                buttonText = buttonText,
                // callback
                onButtonClick = {
                    isDarkMode = !isDarkMode
                    wasClicked = true
                },
                modifier = modifier.padding(innerPadding)
            )
        }
    }
}

//  Stateless Child Composable
@Composable
fun ChildComposable(
    // receives state parameters text and buttonText
    text: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(16.dp))
        // child composable does not know what happens when it calls onButtonClick
        Button(onClick = onButtonClick) {
            Text(buttonText)
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun PreviewParent() {
    ParentComposable()
}
