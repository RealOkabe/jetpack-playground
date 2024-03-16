package com.realokabe.simplegallery

import android.Manifest
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.nfc.Tag
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import com.realokabe.simplegallery.ui.theme.SimpleGalleryTheme

class MainActivity : ComponentActivity() {

    private val readExternalPermission = Manifest.permission.READ_EXTERNAL_STORAGE
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private val readImagesPermission = Manifest.permission.READ_MEDIA_IMAGES

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                isGranted: Boolean ->
                if (isGranted) {
                    Toast.makeText(applicationContext, "Permissions granted", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Permissions denied", Toast.LENGTH_LONG).show()
                }
            }

        when {
            ContextCompat.checkSelfPermission(
                applicationContext,
                readImagesPermission) == PackageManager.PERMISSION_GRANTED -> {
                    Log.d("*****", "Got the permission")
                }
            else -> {
                requestPermissionLauncher.launch(readImagesPermission)
            }
        }

        setContent {
            SimpleGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleGalleryTheme {
        Greeting("Android")
    }
}