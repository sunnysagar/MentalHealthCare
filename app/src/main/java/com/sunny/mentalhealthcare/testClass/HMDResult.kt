package com.sunny.mentalhealthcare.testClass

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
import com.sunny.mentalhealthcare.activity.MedicalReport
import com.sunny.mentalhealthtracker.R

class HMDResult : AppCompatActivity() {

    companion object{
        const val userId = "mobile"
    }

    lateinit var mauth: FirebaseAuth

    lateinit var database : DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hmdresult)

        val toolbar = findViewById<Toolbar>(R.id.hmdRToolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "HAM-D Result Score"
        mauth = FirebaseAuth.getInstance()

       val HamDTs = findViewById<TextView>(R.id.tcs)
        HamDTs.text = intent.getStringExtra("-")

        val btn = findViewById<Button>(R.id.hmdbtn)

        val userName = intent.getStringExtra(userId)

        btn.setOnClickListener {

            val testScore = HamDTs.text as String

            val user = mauth.currentUser
            val emailId = user!!.email
            val uId = user.uid

            database = FirebaseDatabase.getInstance().getReference("Users")
            val updateData = database.child(uId).child("username")
            updateData.child("test1Score").setValue(testScore)

            val score = testScore.toInt()
            var level :String = ""

            when (score) {
                in 0..7 -> level = "Normal"
                in 8..13 -> level = "Mild Depression"
                in 14..18 -> level = "Moderate Depression"
                in 19..22 -> level = "Severe Depression"
                in 23..100 -> level = "Very Severe Depression"
            }
            updateData.child("test2DepressionLevel").setValue(level)

//            if(testScore.toInt() in 0..7)
//            {
//                updateData.child("test2DepressionLevel").setValue("Normal")
//            }

            val intent = Intent(this, MedicalReport::class.java)
            intent.putExtra(MedicalReport.userId,userName)
            startActivity(intent)
            finish()
        }
    }
}