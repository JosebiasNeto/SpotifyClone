package com.example.spotifyclone

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.spotifyclone.Fragments.Home

class Detalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        window.statusBarColor = Color.LTGRAY
        findViewById<Toolbar>(R.id.toolbar).setNavigationIcon(getDrawable(R.drawable.ic_baseline_arrow_back_24))
        findViewById<Toolbar>(R.id.toolbar).title = null
        findViewById<Toolbar>(R.id.toolbar).setOnClickListener {
            var intent = Intent(this, Home::class.java)
            startActivities(intent)
            finish()
        }
    }

    private fun startActivities(intent: Intent) {

    }
}