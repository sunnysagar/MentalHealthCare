package com.sunny.mentalhealthcare.testClass

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.sunny.mentalhealthtracker.R

class HAMD : AppCompatActivity() {

    companion object{
        const val userId = "mobile"
    }

    lateinit var toolbar: Toolbar

    lateinit var s10: RadioButton
    lateinit var s11: RadioButton
    lateinit var s12: RadioButton
    lateinit var s13: RadioButton

    lateinit var s20: RadioButton
    lateinit var s21: RadioButton
    lateinit var s22: RadioButton
    lateinit var s23: RadioButton

    lateinit var s30: RadioButton
    lateinit var s31: RadioButton
    lateinit var s32: RadioButton
    lateinit var s33: RadioButton

    lateinit var s40: RadioButton
    lateinit var s41: RadioButton
    lateinit var s42: RadioButton

    lateinit var s50: RadioButton
    lateinit var s51: RadioButton
    lateinit var s52: RadioButton

    lateinit var hmd: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hmd)

        toolbar = findViewById(R.id.hmdToolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Hamilton Depression Rating Scale"


        s10 = findViewById(R.id.ck10)
        s11 = findViewById(R.id.ck11)
        s12 = findViewById(R.id.ck12)
        s13 = findViewById(R.id.ck13)
        val s14 = findViewById<RadioButton>(R.id.ck14)

        s20 = findViewById(R.id.ck20)
        s21 = findViewById(R.id.ck21)
        s22 = findViewById(R.id.ck22)
        s23 = findViewById(R.id.ck23)
        val s24 = findViewById<RadioButton>(R.id.ck24)

        s30 = findViewById(R.id.ck30)
        s31 = findViewById(R.id.ck31)
        s32 = findViewById(R.id.ck32)
        s33 = findViewById(R.id.ck33)
        val s34 = findViewById<RadioButton>(R.id.ck34)

        s40 = findViewById(R.id.ck40)
        s41 = findViewById(R.id.ck41)
        s42 = findViewById(R.id.ck42)


        s50 = findViewById(R.id.ck50)
        s51 = findViewById(R.id.ck51)
        s52 = findViewById(R.id.ck52)


        val s60 = findViewById<RadioButton>(R.id.ck60)
        val s61 = findViewById<RadioButton>(R.id.ck61)
        val s62 = findViewById<RadioButton>(R.id.ck62)


        val s70 = findViewById<RadioButton>(R.id.ck70)
        val s71 = findViewById<RadioButton>(R.id.ck71)
        val s72 = findViewById<RadioButton>(R.id.ck72)
        val s73 = findViewById<RadioButton>(R.id.ck73)
        val s74 = findViewById<RadioButton>(R.id.ck74)

        val s80 = findViewById<RadioButton>(R.id.ck80)
        val s81 = findViewById<RadioButton>(R.id.ck81)
        val s82 = findViewById<RadioButton>(R.id.ck82)
        val s83 = findViewById<RadioButton>(R.id.ck83)
        val s84 = findViewById<RadioButton>(R.id.ck84)

        val s90 = findViewById<RadioButton>(R.id.ck90)
        val s91 = findViewById<RadioButton>(R.id.ck91)
        val s92 = findViewById<RadioButton>(R.id.ck92)

        val s100 = findViewById<RadioButton>(R.id.ck100)
        val s101 = findViewById<RadioButton>(R.id.ck101)
        val s102 = findViewById<RadioButton>(R.id.ck102)
        val s103 = findViewById<RadioButton>(R.id.ck103)
        val s104 = findViewById<RadioButton>(R.id.ck104)

        val s110 = findViewById<RadioButton>(R.id.ck110)
        val s111 = findViewById<RadioButton>(R.id.ck111)
        val s112 = findViewById<RadioButton>(R.id.ck112)
        val s113 = findViewById<RadioButton>(R.id.ck113)
        val s114 = findViewById<RadioButton>(R.id.ck114)

        val s120 = findViewById<RadioButton>(R.id.ck120)
        val s121 = findViewById<RadioButton>(R.id.ck121)
        val s122 = findViewById<RadioButton>(R.id.ck122)


        val s130 = findViewById<RadioButton>(R.id.ck130)
        val s131 = findViewById<RadioButton>(R.id.ck131)
        val s132 = findViewById<RadioButton>(R.id.ck132)


        val s140 = findViewById<RadioButton>(R.id.ck140)
        val s141 = findViewById<RadioButton>(R.id.ck141)
        val s142 = findViewById<RadioButton>(R.id.ck142)


        val s150 = findViewById<RadioButton>(R.id.ck150)
        val s151 = findViewById<RadioButton>(R.id.ck151)
        val s152 = findViewById<RadioButton>(R.id.ck152)
        val s153 = findViewById<RadioButton>(R.id.ck153)
        val s154 = findViewById<RadioButton>(R.id.ck154)

        val s160 = findViewById<RadioButton>(R.id.ck160)
        val s161 = findViewById<RadioButton>(R.id.ck161)
        val s162 = findViewById<RadioButton>(R.id.ck162)


        val s170 = findViewById<RadioButton>(R.id.ck170)
        val s171 = findViewById<RadioButton>(R.id.ck171)
        val s172 = findViewById<RadioButton>(R.id.ck172)

        hmd = findViewById(R.id.hdbtn)

        val userName = intent.getStringExtra(userId)

        val s1 = arrayOf<RadioButton>(s11,s21,s31,s41,s51,s61,s71,s81,s91,s101,s111,s121,s131,s141,s151,s161,s171)
        val s2 = arrayOf<RadioButton>(s12,s22,s32,s42,s52,s62,s72,s82,s92,s102,s112,s122,s132,s142,s152,s162,s172)
        val s3 = arrayOf<RadioButton>(s13,s23,s33,s73,s83,s103,s113,s153)
        val s4 = arrayOf<RadioButton>(s14,s24,s34,s74,s84,s104,s114,s154)

        hmd.setOnClickListener {
            var score :Int = 0
            var HamDTotalScore : String = ""

            for (i in s1.indices)
            {
                if(s1[i].isChecked)
                    score += 1
            }

            for (i in s2.indices)
            {
                if(s2[i].isChecked)
                    score += 2
            }
            for (i in s3.indices)
            {
                if(s3[i].isChecked)
                    score += 3
            }
            for (i in s4.indices)
            {
                if(s4[i].isChecked)
                    score += 4
            }


            HamDTotalScore = "$score"

//            Toast.makeText(this,"Your total score is $score.",Toast.LENGTH_LONG).show()
            var intent = Intent(this, HMDResult::class.java)
            intent.putExtra("-", HamDTotalScore)
            intent.putExtra(HMDResult.userId,userName)
            startActivity(intent)

        }

    }
}