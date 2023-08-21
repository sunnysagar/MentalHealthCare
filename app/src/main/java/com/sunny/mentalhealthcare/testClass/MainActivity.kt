package com.sunny.mentalhealthcare.testClass

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sunny.mentalhealthtracker.R


class MainActivity : AppCompatActivity() {
    lateinit var mauth:FirebaseAuth

    companion object{
        const val userId = "mobile"
    }

    lateinit var s1: CheckBox
    lateinit var s2: CheckBox
    lateinit var s3: CheckBox
    lateinit var s4: CheckBox
    lateinit var s5: CheckBox
    lateinit var s6: CheckBox
    lateinit var s7: CheckBox
    lateinit var s8: CheckBox
    lateinit var s9: CheckBox
    lateinit var s10: CheckBox
    lateinit var s11: CheckBox
    lateinit var s12: CheckBox
    lateinit var btn: Button
    lateinit var d: TextView
    lateinit var nd:TextView

    lateinit var database: DatabaseReference

    var usN:String = ""


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.mddToolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Major Depressive Disorder"

        mauth = FirebaseAuth.getInstance()


        s1 = findViewById(R.id.checkBox1)
        s2 = findViewById(R.id.checkBox2)
        s3 = findViewById(R.id.checkBox3)
        s4 = findViewById(R.id.checkBox4)
        s5 = findViewById(R.id.checkBox5)
        s6 = findViewById(R.id.checkBox6)
        s7 = findViewById(R.id.checkBox7)
        s8 = findViewById(R.id.checkBox8)
        s9 = findViewById(R.id.checkBox9)
        s10 = findViewById(R.id.checkBox10)
        s11 = findViewById(R.id.checkBox11)
        s12 = findViewById(R.id.checkBox12)
        btn = findViewById(R.id.btn)

        val symptoms = arrayOf(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12)

        val userName = intent.getStringExtra(userId)
        usN = userName.toString()


        btn.setOnClickListener {

            var totalChecked : Int = 0

            var sym1 : String = ""
            var sym2 : String = ""
            var sym3 : String = ""
            var sym4 : String = ""
            var sym5 : String = ""
            var sym6 : String = ""
            var sym7 : String = ""
            var sym8 : String = ""
            var sym9 : String = ""
            var sym10 : String = ""
            var sym11 : String = ""
            var sym12 : String = ""

            for (i in symptoms.indices)
            {
                if(symptoms[i].isChecked) {
                    totalChecked++
                }

            }

            if(s1.isChecked) {

                sym1 = "Sadness"

            }
            if(s2.isChecked) {

                sym2 = "Frustration"
            }
            if(s3.isChecked){

                sym3 = "Pleasure"
            }
            if(s4.isChecked){

                sym4 = "Insomnia"
            }
            if(s5.isChecked){

                sym5 = "Tiredness"
            }
            if(s6.isChecked) {

                sym6 = "Weight"
            }
            if(s7.isChecked) {

                sym7 = "Anxiety"
            }
            if(s8.isChecked) {
                sym8 = "Agility"
            }
            if(s9.isChecked) {

                sym9 = "Guilt"
            }
            if(s10.isChecked) {

                sym10 = "Suicide"
            }
            if(s11.isChecked) {

                sym11 = "Concentration"
            }
            if(s12.isChecked) {

                sym12 = "BackPain"
            }

                updateSymptoms(sym1,sym2,sym3,sym4,sym5,sym6,sym7,sym8,sym9,sym10,sym11,sym12)


            if(totalChecked==0)
                Toast.makeText(this, "select at least one", Toast.LENGTH_SHORT).show()
           else
            {
                val intent = Intent(this, Worry::class.java)
                intent.putExtra(Worry.userId,userName)
                startActivity(intent)
            }


        }



    }

    private fun updateSymptoms(
        sym1: String,
        sym2: String,
        sym3: String,
        sym4: String,
        sym5: String,
        sym6: String,
        sym7: String,
        sym8: String,
        sym9: String,
        sym10: String,
        sym11: String,
        sym12: String
    ) {
        val user = mauth.currentUser
        val emailId = user!!.email
        val uId = user.uid

        database = FirebaseDatabase.getInstance().getReference("Users")
        val symptom1: String= sym1
        val symptom2: String= sym2
        val symptom3: String= sym3
        val symptom4: String= sym4
        val symptom5: String= sym5
        val symptom6: String= sym6
        val symptom7: String= sym7
        val symptom8: String= sym8
        val symptom9: String= sym9
        val symptom10: String= sym10
        val symptom11: String= sym11
        val symptom12: String= sym12

        database.child(uId).child("username").child("symptom1").setValue(symptom1)
        database.child(uId).child("username").child("symptom2").setValue(symptom2)
        database.child(uId).child("username").child("symptom3").setValue(symptom3)
        database.child(uId).child("username").child("symptom4").setValue(symptom4)
        database.child(uId).child("username").child("symptom5").setValue(symptom5)
        database.child(uId).child("username").child("symptom6").setValue(symptom6)
        database.child(uId).child("username").child("symptom7").setValue(symptom7)
        database.child(uId).child("username").child("symptom8").setValue(symptom8)
        database.child(uId).child("username").child("symptom9").setValue(symptom9)
        database.child(uId).child("username").child("symptom10").setValue(symptom10)
        database.child(uId).child("username").child("symptom11").setValue(symptom11)
        database.child(uId).child("username").child("symptom12").setValue(symptom12)


    }

}