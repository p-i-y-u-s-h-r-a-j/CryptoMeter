package com.example.cryptometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.example.cryptometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view)
        val navController = navHostFragment!!.findNavController()

        val popMenu = PopupMenu(this, null)
        popMenu.inflate(R.menu.bottom_bar)
        binding.menuBar.setupWithNavController(popMenu.menu,navController)
    }
}