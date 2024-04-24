package com.lifesider7.regata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.common.reflect.Reflection.initialize

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var sp = getSharedPreferences("PC", Context.MODE_PRIVATE)
        sp.edit().putString("TY","9").commit()
        var emailname:TextView = findViewById(R.id.emailname)
        emailname.text = sp.getString("email", "не загрузилось. поовторите попытку")
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}