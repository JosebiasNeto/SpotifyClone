package com.example.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.spotifyclone.Fragments.Biblioteca
import com.example.spotifyclone.Fragments.Buscar
import com.example.spotifyclone.Fragments.Home
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var Content: FrameLayout? = null

    private var mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener OnNavigationItemSelecteListener@{ item ->
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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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