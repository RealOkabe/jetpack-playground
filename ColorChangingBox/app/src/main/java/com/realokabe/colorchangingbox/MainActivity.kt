package com.realokabe.colorchangingbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.realokabe.colorchangingbox.ui.theme.ColorChangingBoxTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorChangingBoxTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    val color = remember {
                        mutableStateOf(
                            Color.Red
                        )
                    }
                    Box(
                        Modifier
                            .background(color = color.value, shape = RectangleShape)
                            .width(300.dp)
                            .height(300.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Button(
                        onClick = {
                                  color.value = Color(
                                      Random.nextFloat(),
                                      Random.nextFloat(),
                                      Random.nextFloat(),
                                      1f
                                  )
                        },
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier
                            .width(200.dp)
                            .height(120.dp)
                            .padding(20.dp)
                        ,
                        shape = RectangleShape,
                    ) {
                        Text(text = "Change Color", fontSize = 15.sp)
                    }
                }
            }
        }
    }
}