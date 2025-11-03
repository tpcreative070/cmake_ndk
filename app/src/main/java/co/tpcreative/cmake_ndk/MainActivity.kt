package co.tpcreative.cmake_ndk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.tpcreative.NativeClass
import co.tpcreative.cmake_ndk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = NativeClass().stringFromJNI()
    }

    /**
     * A native method that is implemented by the 'cmake_ndk' native library,
     * which is packaged with this application.
     */


    companion object {
        // Used to load the 'cmake_ndk' library on application startup.
        init {
            System.loadLibrary("tp_creative")
        }
    }
}