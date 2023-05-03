package com.sunny.mentalhealthcare.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sunny.mentalhealthtracker.R

class Worry : AppCompatActivity() {

    companion object{
        const val userId = "mobile"
    }

    lateinit var mauth: FirebaseAuth
    lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worry)

        val toolbar = findViewById<Toolbar>(R.id.mddSToolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Severity of Depression"

        mauth = FirebaseAuth.getInstance()

        val userName = intent.getStringExtra(userId)

        val btnBDI = findViewById<Button>(R.id.btbdi)
        btnBDI.setOnClickListener {
            val test = "BDI Test"

            val user = mauth.currentUser
            val emailId = user!!.email
            val uId = user.uid

            database = FirebaseDatabase.getInstance().getReference("Users")
            val updateData = database.child(uId).child("username")
            updateData.child("test0Selected").setValue(test)

            val intent = Intent(this, BDI::class.java)
            intent.putExtra(BDI.userId,userName)
            startActivity(intent)

        }

        val btnHMD = findViewById<Button>(R.id.bthamd)
        btnHMD.setOnClickListener {

            val test = "HAM-D Test"

            val user = mauth.currentUser
            val emailId = user!!.email
            val uId = user.uid
            database = FirebaseDatabase.getInstance().getReference("Users")
            val updateData = database.child(uId).child("username")
            updateData.child("test0Selected").setValue(test)
//            database.child(userName.toString()).child("test0Selected").setValue(test)

            val intent = Intent(this, HAMD::class.java)
            intent.putExtra(HAMD.userId,userName)
            startActivity(intent)
        }
    }
}