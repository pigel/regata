package com.lifesider7.regata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lifesider7.regata.R.id.button
import com.lifesider7.regata.R.id.email
import com.lifesider7.regata.R.id.password

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var email:TextView = findViewById(email)
        var password:TextView = findViewById(password)
        var button:Button = findViewById(R.id.button)
            button.setOnClickListener{
                if(email.text.isEmpty() || email.text.contains("@"))
                    Toast.makeText(this, "Проверьте email", Toast.LENGTH_LONG).show()
                else if (password.text.isEmpty() || email.text.length<6)
                    Toast.makeText(this, "Пароль должен быть больше шести символов", Toast.LENGTH_LONG).show()
                else{
                    //code will be here
                }
                }

    }
}