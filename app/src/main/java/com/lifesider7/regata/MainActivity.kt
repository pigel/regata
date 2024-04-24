package com.lifesider7.regata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var sp = getSharedPreferences("PC", Context.MODE_PRIVATE)
        if (sp.getString("TY", "-9")!="-9"){
            startActivity(Intent(this, MainActivity2::class.java))
        }
        else{
            var signUp : TextView = findViewById(R.id.textView)
            signUp.setOnClickListener{
                var intent = Intent(this,Signup::class.java)
                startActivity(intent)
            }

        }


    }
//    stop
}