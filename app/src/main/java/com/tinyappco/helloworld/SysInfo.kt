package com.tinyappco.helloworld

import android.content.Context
import android.opengl.GLSurfaceView
import android.os.Build

class SysInfo(private val context: Context) {

    // Method to gather system information
    fun getSystemInfo(callback: (String) -> Unit) {
        // Android version
        val androidVersion = Build.VERSION.SDK_INT
        val androidVersionName = Build.VERSION.RELEASE

        // Kernel version
        val kernelVersion = System.getProperty("os.version")

        // Architecture
        val architecture = Build.SUPPORTED_ABIS[0]

        // GPU info using GLSurfaceView
        val glSurfaceView = GLSurfaceView(context)
        glSurfaceView.setRenderer(object : GLSurfaceView.Renderer {
            override fun onSurfaceCreated(gl: javax.microedition.khronos.opengles.GL10?, config: javax.microedition.khronos.egl.EGLConfig?) {
                val renderer = gl?.glGetString(javax.microedition.khronos.opengles.GL10.GL_RENDERER)
                val vendor = gl?.glGetString(javax.microedition.khronos.opengles.GL10.GL_VENDOR)

                // Assemble the system information
                val systemInfo = """
                    Android Version: $androidVersion ($androidVersionName)
                    Linux Kernel Version: $kernelVersion
                    Architecture: $architecture
                    GPU Renderer: $renderer
                    GPU Vendor: $vendor
                """.trimIndent()

                // Call the callback with the system info
                callback(systemInfo)
            }

            override fun onSurfaceChanged(gl: javax.microedition.khronos.opengles.GL10?, width: Int, height: Int) {}
            override fun onDrawFrame(gl: javax.microedition.khronos.opengles.GL10?) {}
        })

        // Add GLSurfaceView to the layout (optional, for getting GPU info)
        // Normally you would set this in your layout or temporarily.
        // context.addView(glSurfaceView)
    }
}
