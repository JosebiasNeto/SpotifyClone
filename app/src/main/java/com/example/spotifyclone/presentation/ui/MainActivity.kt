package com.example.spotifyclone.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.spotifyclone.presentation.Fragments.Biblioteca
import com.example.spotifyclone.presentation.Fragments.Buscar
import com.example.spotifyclone.presentation.Fragments.Home
import com.example.spotifyclone.R
import com.example.spotifyclone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var Content: FrameLayout? = null

    private var mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener OnNavigationItemSelecteListener@{ item ->
        when (item.itemId){
            R.id.nav_inicio -> {
                val fragment = Home.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelecteListener true
            }
            R.id.nav_buscar -> {
                val fragment = Buscar.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelecteListener true
            }
            R.id.nav_biblioteca -> {
                val fragment = Biblioteca.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelecteListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Content = findViewById(R.id.content)
        findViewById<BottomNavigationView>(R.id.bottom_menu).setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = Home.newInstance()
        addFragment(fragment)

        supportActionBar!!.hide()
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}