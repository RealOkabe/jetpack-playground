package com.realokabe.app1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.realokabe.app1.ui.theme.Application1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application1Theme {
                Greeting(this)
            }
        }
    }
}

// Composable functions are the ones that compose the UI
@Composable
fun Greeting(context: Context) {
    Column (
        // The border looks weird because the order of modifiers applied matters. If border is applied before padding, then it will look normal
        // Only the area inside the border is clickable
        Modifier
            .fillMaxSize(0.3f)
            .background(color = Color.Cyan)
            .padding(20.dp)
            .border(width = 5.dp, color = Color.Yellow)
            .clickable {
                Toast.makeText(context, "Yes this is clickable!", Toast.LENGTH_LONG).show()
            }
    ) {
        Text(text = "Hello")
        // Add blank composable of height 20dp
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "World!")
    }
}

// Preview function can be used to check the output of the composable functions without having to open the app
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Application1Theme {
        Greeting(LocalContext.current)
    }
}