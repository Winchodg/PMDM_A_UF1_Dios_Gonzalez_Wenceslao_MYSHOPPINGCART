package com.example.myshoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.myshoppingcart.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // referencia al drawer layout
        val drawer = binding.drawerLayout

        // referencia toolbar
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        // referencia al controlador de navegación.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // configuración de la toolbar.
        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(drawer)
        val appBarConfig = builder.build()

        toolbar.setupWithNavController(navController, appBarConfig)

        // enlazar el drawer con el sistema de navegación
        val navView = binding.navView
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return NavigationUI.onNavDestinationSelected(item, navController) ||
            super.onOptionsItemSelected(item)

    }
}