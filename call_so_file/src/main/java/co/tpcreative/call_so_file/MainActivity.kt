package co.tpcreative.call_so_file

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import co.tpcreative.NativeClass
import co.tpcreative.call_so_file.ui.theme.Cmake_ndkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cmake_ndkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box (Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center){
                        Row ( horizontalArrangement = Arrangement.Center) {
                            Text( text = "Android ${NativeClass().stringFromJNI()}", textAlign = TextAlign.Center)
                        }
                    }

                }
            }
        }
    }

    companion object {
        // Used to load the 'cmake_ndk' library on application startup.
        init {
            System.loadLibrary("tp_creative")
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
    Cmake_ndkTheme {
        Greeting("Android")
    }
}