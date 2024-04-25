package com.lifesider7.regata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
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
        var sp = getSharedPreferences("PC", Context.MODE_PRIVATE).edit()
        var email:TextView = findViewById(email)
        var password:TextView = findViewById(password)

        var signIn : TextView = findViewById(R.id.textView)
        signIn.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        var button:Button = findViewById(R.id.button)
            button.setOnClickListener{
                if(email.text.isEmpty() || !email.text.contains("@"))
                    Toast.makeText(this, "Проверьте email", Toast.LENGTH_LONG).show()
                else if (password.text.isEmpty() || email.text.length<6)
                    Toast.makeText(this, "Пароль должен быть больше шести символов", Toast.LENGTH_LONG).show()
                else{
                    //code will be here
                    val db = Firebase.firestore
                    val user = hashMapOf(
                        "email" to email.text.toString(),
                        "password" to password.text.toString()
                    )


// Add a new document with a generated ID
                    db.collection("users")
                        .add(user)
                        .addOnSuccessListener { documentReference ->
                            sp.putString("email", email.text.toString()).commit()
                            startActivity(Intent(this, MainActivity2::class.java))
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Не получилось", Toast.LENGTH_LONG).show()
                        }

                }
                }

    }
}