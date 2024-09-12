package com.tinyappco.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tinyappco.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Create SysInfo instance and get system info
        val sysInfo = SysInfo(this)
        sysInfo.getSystemInfo { systemInfo ->
            // Display system info in the UI
            runOnUiThread {
                binding.tvGreeting.text = systemInfo
            }
        }
    }
}
