package com.tinyappco.helloworld

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tinyappco.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Android version
        val androidVersion = Build.VERSION.SDK_INT
        val androidVersionName = Build.VERSION.RELEASE

        // Kernel version
        val kernelVersion = System.getProperty("os.version")

        // Architecture
        val architecture = Build.SUPPORTED_ABIS[0]

        // GPU info
        val renderer = android.opengl.GLES20.glGetString(android.opengl.GLES20.GL_RENDERER)
        val vendor = android.opengl.GLES20.glGetString(android.opengl.GLES20.GL_VENDOR)

        // Combine the information
        val systemInfo = """
            Android Version: $androidVersion ($androidVersionName)
            Linux Kernel Version: $kernelVersion
            Architecture: $architecture
            GPU Renderer: $renderer
            GPU Vendor: $vendor
        """.trimIndent()

        // Display the system info
        binding.tvGreeting.text = systemInfo
    }
}
