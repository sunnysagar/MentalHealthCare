package com.sunny.mentalhealthcare.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.sunny.mentalhealthtracker.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    lateinit var emaill: TextView
    lateinit var password: TextView
    lateinit var mauth: FirebaseAuth

    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mauth = FirebaseAuth.getInstance()

        emaill = findViewById(R.id.etMobile)
        password = findViewById(R.id.etPassword)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val register = findViewById<TextView>(R.id.txtRegister)

        val useName = intent.getStringExtra("useName")

        btnLogin.setOnClickListener {
            if(validateUsername() == true && validatePassword() == true)
            {
                val email = emaill.text.toString()
                val password = password.text.toString()
                lifecycleScope.launch(Dispatchers.IO) {
                    signInWithEmailAndPassword(mauth,email,password)
                }
            }
            else
                Toast.makeText(this@LoginActivity, "Please check your credentials.", Toast.LENGTH_SHORT).show()





//            if (useName != null) {
//
//            }


//            fun onClick(view: View?) {
//                if (!validateUsername()!! or !validatePassword()!!) {
//                } else {
//
//                }
//            }


//            if(!val)

//            database = FirebaseDatabase.getInstance().getReference("Users")


//            val emailId = email.text.toString()
//            lifecycleScope.launch(Dispatchers.IO) {
//                signInWithEmailAndPassword(mauth,emailId,password)
//            }


//            val intent = Intent(this, BasicDetails::class.java)
//            startActivity(intent)
        }
        register.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }


    }

    fun validateUsername(): Boolean {
        val `val`: String = emaill.text.toString()
        return if (`val`.isEmpty()) {
            emaill.error = "Username cannot be empty"
            false
        } else {
            emaill.error = null
            true
        }
    }

    fun validatePassword(): Boolean {
        val `val`: String = password.text.toString()
        return if (`val`.isEmpty()) {
            password.error = "Password cannot be empty"
            false
        } else {
            password.error = null
            true
        }
    }

    suspend fun signInWithEmailAndPassword(firebaseAuth: FirebaseAuth, email: String, passwordd: String):AuthResult? {

        return try{
            val result = firebaseAuth.signInWithEmailAndPassword(email,passwordd).await()
//            Toast.makeText(this,"${result.user?.email}",Toast.LENGTH_SHORT).show()
//            Log.d("AuthResult","${result.user?.email}")
            startActivity(Intent(this@LoginActivity,CheckUp::class.java))
            result
        }catch (e:Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@LoginActivity,"${e.message}", Toast.LENGTH_SHORT).show()
                Log.d("AuthResult","${e.message}")

            }
            null
        }

//            return try {
//                val result = firebaseAuth.signInWithEmailAndPassword(email, passwordd).await()
//                startActivity(Intent(this@LoginActivity,CheckUp::class.java))
////            Toast.makeText(this,"${result.user?.email}",Toast.LENGTH_SHORT).show()
////            Log.d("AuthResult","${result.user?.email}")
//
//                result
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(this@LoginActivity, "${e.message}", Toast.LENGTH_SHORT).show()
//                    Log.d("AuthResult", "${e.message}")
//
//                }
//                null
//            }


    }
}