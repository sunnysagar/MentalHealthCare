package com.sunny.mentalhealthcare.activity

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.sunny.mentalhealthcare.base.Interest
import com.sunny.mentalhealthcare.base.PDFConverter
import com.sunny.mentalhealthcare.model.InfoDetails
import com.sunny.mentalhealthcare.model.Users
import kotlinx.coroutines.NonCancellable.cancel


class MedicalReport : AppCompatActivity() {

    companion object{
        const val userId = "mobile"
    }

    lateinit var genrtBtn: Button
//    lateinit var phone: TextView
    lateinit var mauth: FirebaseAuth
    lateinit var database: DatabaseReference


    var pageHeight = 1120
    var pageWidth = 792

    lateinit var bmp: Bitmap
    lateinit var scaledbmp: Bitmap

    // constant code for runtime permissions
    private val PERMISSION_REQUEST_CODE = 101

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.sunny.mentalhealthtracker.R.layout.activity_medical_report)

        mauth = FirebaseAuth.getInstance()

//        phone = findViewById(R.id.mobile)
        genrtBtn = findViewById(com.sunny.mentalhealthtracker.R.id.btnGentr)
//        bmp = BitmapFactory.decodeResource(getResources(), com.sunny.mentalhealthtracker.R.drawable.brain);
//        scaledbmp = Bitmap.createScaledBitmap(bmp, 140, 140, false);

        // below code is used for
        // checking our permissions.
        if (checkPermissions()) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            requestPermission();
        }

        var UseName = Users()

        var mobile: String=""
        val userName = intent.getStringExtra(userId)
//        phone.text = userName.toString()
//        mobile = phone.text as String


        genrtBtn.setOnClickListener {

            // on below line we are calling generate
            // PDF method to generate our PDF file.
//            generatePDF()
//            val mobile: String = phone.text.toString()
            var fname: String = ""

            val user = mauth.currentUser
            val emailId = user!!.email
            val uId = user.uid

            val list  = arrayOf<String>()

                database = FirebaseDatabase.getInstance().getReference("Users")

//                database.addValueEventListener(object :ValueEventListener
//                {
//                    override fun onDataChange(snapshot: DataSnapshot) {
////                        var pInterestList : MutableMap<String,String> = mutableMapOf()
//
//
////                        for (dataSnapshot in snapshot.children)
////                        {
////                            pInterestList.clear()
////                            var i=0
////                            while (true) {
////                                pInterestList[0.toString()] = dataSnapshot.value as String
////                                i++
////                            }
//                        val children = snapshot.children
//                        children.forEach {
//                            println(it.toString())
//                        }
//
//
//                    }
//
//                    override fun onCancelled(error: DatabaseError) {
//                        cancel()
//                    }
//
//                })

                database.child(uId).child("username").addValueEventListener(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot){

                        var pName:String=""
                        var pAge: String = ""
                        var pMobile: String = ""
                        var pEmail: String = ""
                        var pJob: String = ""
                        var pCity: String = ""
                        var pState: String = ""
                        var pGender: String = ""
                        var pMarry: String = ""
                        var pTymOnPhone : String = ""
                        var pMeetPeople: String = ""
                        var pMood: String = ""
                        var pFitness: String = ""
                        var pInt1:String = ""
                        var pInt2:String = ""

                        var pS1:String = ""
                        var pS2:String = ""
                        var pS3:String = ""
                        var pS4:String = ""
                        var pS5:String = ""
                        var pS6:String = ""
                        var pS7:String = ""
                        var pS8:String = ""
                        var pS9:String = ""
                        var pS10:String = ""
                        var pS11:String = ""
                        var pS12:String = ""

                        var pTest:String = ""
                        var pTestScore:String = ""
                        var pDepLevel:String = ""


                        var pInterestList : MutableMap<String, Interest> = mutableMapOf()




                        val it = dataSnapshot
                        if (it.exists()) {

                            pName = it.child("name").value as String
                            pAge = it.child("age").value as String
                            pMobile = it.child("mobile").value as String
                            pEmail =  it.child("email").value as String
                            pJob =  it.child("job").value as String
                            pCity =  it.child("city").value as String
                            pState =  it.child("state").value as String
                            pGender = it.child("gender").value as String
                            pMarry = it.child("maritalStatus").value as String
                            pTymOnPhone = it.child("tymOnPhone").value as String
                            pMeetPeople = it.child("meetPeopleCount").value as String
                            pMood = it.child("todaySMood").value as String
                            pFitness = it.child("fitness").value as String

                            pInt1 = it.child("interest1").value as String
                            pInt2 = it.child("interest2").value as String
//                            pInterestList = (it.child("interestList").children.forEach())

                            pS1 = it.child("symptom1").value as String
                            pS2 = it.child("symptom2").value as String
                            pS3 = it.child("symptom3").value as String
                            pS4 = it.child("symptom4").value as String
                            pS5 = it.child("symptom5").value as String
                            pS6 = it.child("symptom6").value as String
                            pS7 = it.child("symptom7").value as String
                            pS8 = it.child("symptom8").value as String
                            pS9 = it.child("symptom9").value as String
                            pS10 = it.child("symptom10").value as String
                            pS11 = it.child("symptom11").value as String
                            pS12 = it.child("symptom12").value as String

                            pTest = it.child("test0Selected").value as String
                            pTestScore = it.child("test1Score").value as String
                            pDepLevel = it.child("test2DepressionLevel").value as String




                        }

                        val infoList = InfoDetails(pName, pAge, pMobile, pEmail, pJob, pCity, pState, pGender, pMarry, pTymOnPhone, pMeetPeople, pMood, pFitness,
                                                    pInt1,pInt2,pS1,pS2,pS3,pS4,pS5,pS6,pS7,pS8,pS9,pS10,pS11,pS12, pTest, pTestScore, pDepLevel)

                        val pdfConverter = PDFConverter()
                        pdfConverter.createPdf(this@MedicalReport, infoList, this@MedicalReport)

//                        Handler().postDelayed ({
//                            val intent = Intent(this@MedicalReport, CheckUp::class.java)
//                            startActivity(intent)
//                            finish()
//                        },1100)

                    }
                     override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                        cancel()
                    }
                })

//                database.child(mobile).get().addOnSuccessListener {
//
//                }
//
//
//
        }

        val btnh = findViewById<Button>(com.sunny.mentalhealthtracker.R.id.btnHome)

        btnh.setOnClickListener {
            val intent = Intent(this@MedicalReport, AfterTestActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

        fun checkPermissions(): Boolean {
            // on below line we are creating a variable for both of our permissions.

            // on below line we are creating a variable for
            // writing to external storage permission
            var writeStoragePermission = ContextCompat.checkSelfPermission(
                applicationContext,
                WRITE_EXTERNAL_STORAGE
            )

            // on below line we are creating a variable
            // for reading external storage permission
            var readStoragePermission = ContextCompat.checkSelfPermission(
                applicationContext,
                READ_EXTERNAL_STORAGE
            )

            // on below line we are returning true if both the
            // permissions are granted and returning false
            // if permissions are not granted.
            return writeStoragePermission == PackageManager.PERMISSION_GRANTED
                    && readStoragePermission == PackageManager.PERMISSION_GRANTED
        }

        private fun requestPermission() {
            // requesting permissions if not provided.
            ActivityCompat.requestPermissions(
                this,
                arrayOf(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_CODE
            )
        }

        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            // on below line we are checking if the
            // request code is equal to permission code.
            if (requestCode == PERMISSION_REQUEST_CODE) {

                // on below line we are checking if result size is > 0
                if (grantResults.size > 0) {

                    // on below line we are checking
                    // if both the permissions are granted.
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1]
                        == PackageManager.PERMISSION_GRANTED
                    ) {

                        // if permissions are granted we are displaying a toast message.
                        Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show()

                    } else {

                        // if permissions are not granted we are
                        // displaying a toast message as permission denied.
                        Toast.makeText(this, "Permission Denied..", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }
        }


}