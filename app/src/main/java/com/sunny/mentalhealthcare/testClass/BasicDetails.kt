package com.sunny.mentalhealthcare.testClass

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sunny.mentalhealthcare.model.Details
import com.sunny.mentalhealthtracker.R

open class BasicDetails : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var age : EditText
    lateinit var mobile: EditText
    lateinit var email: EditText
    lateinit var job: EditText
    lateinit var city: EditText
    lateinit var state: EditText
    lateinit var gender:RadioGroup
    lateinit var gM: RadioButton
    lateinit var gF: RadioButton
    lateinit var marry: RadioGroup
    lateinit var mY: RadioButton
    lateinit var mN: RadioButton

    //Interest
    lateinit var movies:CheckBox
    lateinit var music:CheckBox
    lateinit var trv:CheckBox
    lateinit var sports:CheckBox
    lateinit var arts:CheckBox
    lateinit var cooking:CheckBox

    lateinit var phoneTym: EditText
    lateinit var meetpepls: EditText
    lateinit var feel: EditText
    lateinit var fitness: EditText

    lateinit var btnNxt :Button

    lateinit var sharedPreferences: SharedPreferences

    lateinit var mauth : FirebaseAuth

    lateinit var database:DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_details)


        name = findViewById(R.id.bdName)
        age = findViewById(R.id.bdAge)
        mobile = findViewById(R.id.bdMobile)
        email = findViewById(R.id.bdEmail)
        job = findViewById(R.id.bdJob)
        city = findViewById(R.id.bdCity)
        state = findViewById(R.id.bdState)

        //Gender
        gender = findViewById(R.id.bdRadioGen)
        gM = findViewById(R.id.bdGM)
        gF = findViewById(R.id.bdGF)

        //marry
        marry = findViewById(R.id.bdRadioMarry)
        mY = findViewById(R.id.bdMSingle)
        mN = findViewById(R.id.bdMMd)

        //Interest
        movies = findViewById(R.id.bdMovies)
        music = findViewById(R.id.bdMusic)
        trv = findViewById(R.id.bdTrv)
        sports = findViewById(R.id.bdSports)
        arts = findViewById(R.id.bdPainting)
        cooking = findViewById(R.id.bdCooking)

        phoneTym = findViewById(R.id.bdTymP)
        meetpepls = findViewById(R.id.bdpw)
        feel = findViewById(R.id.bdFt)
        fitness = findViewById(R.id.bdFitness)

        btnNxt = findViewById(R.id.btnNxt)


        mauth = FirebaseAuth.getInstance()

//        val Name = name.text.toString()
//        val Age = age.text.toString()
//
//
//        val intent = Intent(this,MedicalReport::class.java)
//        intent.putExtra("Name",Name)
//        intent.putExtra("Age",Age)

        sharedPreferences = getSharedPreferences("MySharedPref",Context.MODE_PRIVATE)

//        val phone:String = mobile.text.toString()

        btnNxt.setOnClickListener {

            val name:String = name.text.toString()
            val age:String = age.text.toString()
            val mobile:String = mobile.text.toString()
            val email:String = email.text.toString()
            val job:String = job.text.toString()
            val city:String = city.text.toString()
            val state:String = state.text.toString()
            val tymOnPhone:String = phoneTym.text.toString()
            val meetPeople:String = meetpepls.text.toString()
            val feelToday:String = feel.text.toString()
            val fitness:String = fitness.text.toString()

            //setting data for gender
            var gender: String = ""
            if(gM.isChecked)
                gender = gM.text.toString()
            if(gF.isChecked)
                gender = gF.text.toString()

            //setting data for maritalStatus
            var marrySt:String = ""
            if(mY.isChecked)
                marrySt = mY.text.toString()
            if(mN.isChecked)
                marrySt = mN.text.toString()

            //setting the interest for the database
            val intrss = arrayOf(movies,music,trv,sports,arts,cooking)
            var intrs  = arrayOf<String>("","")

            var totalChecked = 0
//            var id = arrayOf<String>("I11","I22")
            var j =0
            for (i in intrss.indices)
            {
                if(intrss[i].isChecked)
                {
                    intrs[j] = intrss[i].text.toString()
                    j++
                    totalChecked++

                    if(j == 2 && totalChecked == 2 && intrs.size==2)
                        break
                }
            }

            var I1 : String = ""
            var I2 : String = ""

            I1 = intrs[0]
            I2 = intrs[1]






            var sym1 :String = ""
            var sym2 :String = ""
            var sym3 :String = ""
            var sym4 :String = ""
            var sym5 :String = ""
            var sym6 :String = ""
            var sym7 :String = ""
            var sym8 :String = ""
            var sym9 :String = ""
            var sym10 :String = ""
            var sym11 :String = ""
            var sym12 :String = ""

            if(name.isNotEmpty() && age.isNotEmpty() && mobile.isNotEmpty() && email.isNotEmpty() && job.isNotEmpty() && city.isNotEmpty() && state.isNotEmpty()
                && tymOnPhone.isNotEmpty() && meetPeople.isNotEmpty() && feelToday.isNotEmpty() && fitness.isNotEmpty())
            {
                val user = mauth.currentUser
                val emailId = user!!.email
                val uId = user.uid

                database = FirebaseDatabase.getInstance().getReference("Users")

                val detail = Details(name,
                    age,
                    mobile,
                    emailId,
                    job,
                    city,
                    state,
                    gender,
                    marrySt,
                    tymOnPhone,
                    meetPeople,
                    feelToday,
                    fitness,
                    I1,
                    I2,
                    sym1,
                    sym2,
                    sym3,
                    sym4 ,
                    sym5,
                    sym6,
                    sym7,
                    sym8,
                    sym9,
                    sym10,
                    sym11,
                    sym12,
                    "",
                    "",
                    ""




                )
                //You can't use special characters in your firebase node names that's why email as child not working
                database.child(uId).child("username").setValue(detail)

                val builder = AlertDialog.Builder(this@BasicDetails)
                builder.setTitle("Confirmation")
                    .setMessage("have to taken the test before?")
                    .setPositiveButton("Yes"){_, _ ->

                        val intent = Intent(this@BasicDetails, MainActivity::class.java)
                        startActivity(intent)
                        finish()


                        Toast.makeText(this,"Hoping for your improvement!!",Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No"){_, _ ->
                        val intent = Intent(this, CheckUp::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .create()
                    .show()
//                detail.forEach{database.child("Detail").push().key
//                    it.mobile = database.key.toString()
//                    database.child("detail").child(database.key).setValue(it)
//
//                }

            }
            else
                Toast.makeText(this,"All details must be filled!",Toast.LENGTH_SHORT).show()



//            val username = username.text.toString()
//            val mailId = intent.getStringExtra("mail")

            //sending mobile in medical Report
//            val intent = Intent(this@BasicDetails, MedicalReport::class.java)







//            val intent = Intent(this, MainActivity::class.java)


//            database.child(mobile).push().setValue(detail)
        }

//        btnLogOut.setOnClickListener {
//            mauth.signOut()
//            Toast.makeText(this,"Thank You",Toast.LENGTH_SHORT).show()
//            finish()
//        }

    }


//    override fun onResume() {
//        super.onResume()
//
//        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
//        val mob = sh.getInt("mobile", 0)
//
//        mobile.setText(mob.toString())
//    }
//
//    override fun onPause() {
//        super.onPause()
//
//        val sharedPreferences = getSharedPreferences("My SharedPref", MODE_PRIVATE)
//        val myEdit = sharedPreferences.edit()
//
//        myEdit.putString("mobile", mobile.text.toString())
//        myEdit.apply()
//    }
}