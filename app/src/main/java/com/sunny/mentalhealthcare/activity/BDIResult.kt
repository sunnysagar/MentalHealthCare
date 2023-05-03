package com.sunny.mentalhealthcare.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sunny.mentalhealthtracker.R


class BDIResult : AppCompatActivity() {

    companion object{
        const val userId = "mobile"
    }

    lateinit var mauth:FirebaseAuth
    lateinit var BDITs : TextView
    lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bdiresult)

        val toolbar = findViewById<Toolbar>(R.id.bdiRToolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "BDI Result Score"


        mauth = FirebaseAuth.getInstance()

        BDITs = findViewById(R.id.tss)
        BDITs.text = intent.getStringExtra("-")

        val btn = findViewById<Button>(R.id.bdiNxt)

        val userName = intent.getStringExtra(userId)

        btn.setOnClickListener {

            val user = mauth.currentUser
            val emailId = user!!.email
            val uId = user.uid

            val testScore = BDITs.text as String

            database = FirebaseDatabase.getInstance().getReference("Users")
            val updateData = database.child(uId).child("username")
            updateData.child("test1Score").setValue(testScore)

            val score = testScore.toInt()
            var level :String = ""

            when (score) {
                in 1..10 -> level = "Normal"
                in 11..16 -> level = "Mild Mood Disturbance"
                in 17..20 -> level = "Clinical Depression"
                in 21..30 -> level = "Moderate Depression"
                in 31..40 -> level = "Severe Depression"
                in 41..100 -> level = "Extreme Depression"
            }
            updateData.child("test2DepressionLevel").setValue(level)

            val intent = Intent(this,MedicalReport::class.java)
            intent.putExtra(MedicalReport.userId,userName)
            startActivity(intent)
            finish()
        }

    }
}