package com.sunny.mentalhealthcare.testClass

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.sunny.mentalhealthtracker.R

class BDI : AppCompatActivity() {

    companion object{
        const val userId = "mobile"
    }

//Ctl + R to find And Replace a same text in one class
    lateinit var toolbar: Toolbar

    lateinit var s10:RadioButton
    lateinit var s11:RadioButton
    lateinit var s12:RadioButton
    lateinit var s13:RadioButton

    lateinit var s20:RadioButton
    lateinit var s21:RadioButton
    lateinit var s22:RadioButton
    lateinit var s23:RadioButton

    lateinit var s30:RadioButton
    lateinit var s31:RadioButton
    lateinit var s32:RadioButton
    lateinit var s33:RadioButton

    lateinit var s40:RadioButton
    lateinit var s41:RadioButton
    lateinit var s42:RadioButton
    lateinit var s43:RadioButton

    lateinit var s50:RadioButton
    lateinit var s51:RadioButton
    lateinit var s52:RadioButton
    lateinit var s53:RadioButton

    lateinit var bdi: Button

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bdi)

        toolbar = findViewById(R.id.bdiToolbar)

            setSupportActionBar(toolbar)
            supportActionBar?.title = "Beck's Depression Inventory"

            //Hamburger icon adding method
//            supportActionBar?.setHomeButtonEnabled(true)
//            supportActionBar?.setDisplayHomeAsUpEnabled(true)


        s10 = findViewById(R.id.ck10)
        s11 = findViewById(R.id.ck11)
        s12 = findViewById(R.id.ck12)
        s13 = findViewById(R.id.ck13)

        s20 = findViewById(R.id.ck20)
        s21 = findViewById(R.id.ck21)
        s22 = findViewById(R.id.ck22)
        s23 = findViewById(R.id.ck23)

        s30 = findViewById(R.id.ck30)
        s31 = findViewById(R.id.ck31)
        s32 = findViewById(R.id.ck32)
        s33 = findViewById(R.id.ck33)

        s40 = findViewById(R.id.ck40)
        s41 = findViewById(R.id.ck41)
        s42 = findViewById(R.id.ck42)
        s43 = findViewById(R.id.ck43)

        s50 = findViewById(R.id.ck50)
        s51 = findViewById(R.id.ck51)
        s52 = findViewById(R.id.ck52)
        s53 = findViewById(R.id.ck53)

        val s60 = findViewById<RadioButton>(R.id.ck60)
        val s61 = findViewById<RadioButton>(R.id.ck61)
        val s62 = findViewById<RadioButton>(R.id.ck62)
        val s63 = findViewById<RadioButton>(R.id.ck63)

        val s70 = findViewById<RadioButton>(R.id.ck70)
        val s71 = findViewById<RadioButton>(R.id.ck71)
        val s72 = findViewById<RadioButton>(R.id.ck72)
        val s73 = findViewById<RadioButton>(R.id.ck73)

        val s80 = findViewById<RadioButton>(R.id.ck80)
        val s81 = findViewById<RadioButton>(R.id.ck81)
        val s82 = findViewById<RadioButton>(R.id.ck82)
        val s83 = findViewById<RadioButton>(R.id.ck83)

        val s90 = findViewById<RadioButton>(R.id.ck90)
        val s91 = findViewById<RadioButton>(R.id.ck91)
        val s92 = findViewById<RadioButton>(R.id.ck92)
        val s93 = findViewById<RadioButton>(R.id.ck93)

        val s100 = findViewById<RadioButton>(R.id.ck100)
        val s101 = findViewById<RadioButton>(R.id.ck101)
        val s102 = findViewById<RadioButton>(R.id.ck102)
        val s103 = findViewById<RadioButton>(R.id.ck103)

        val s110 = findViewById<RadioButton>(R.id.ck110)
        val s111 = findViewById<RadioButton>(R.id.ck111)
        val s112 = findViewById<RadioButton>(R.id.ck112)
        val s113 = findViewById<RadioButton>(R.id.ck113)

        val s120 = findViewById<RadioButton>(R.id.ck120)
        val s121 = findViewById<RadioButton>(R.id.ck121)
        val s122 = findViewById<RadioButton>(R.id.ck122)
        val s123 = findViewById<RadioButton>(R.id.ck123)

        val s130 = findViewById<RadioButton>(R.id.ck130)
        val s131 = findViewById<RadioButton>(R.id.ck131)
        val s132 = findViewById<RadioButton>(R.id.ck132)
        val s133 = findViewById<RadioButton>(R.id.ck133)

        val s140 = findViewById<RadioButton>(R.id.ck140)
        val s141 = findViewById<RadioButton>(R.id.ck141)
        val s142 = findViewById<RadioButton>(R.id.ck142)
        val s143 = findViewById<RadioButton>(R.id.ck143)

        val s150 = findViewById<RadioButton>(R.id.ck150)
        val s151 = findViewById<RadioButton>(R.id.ck151)
        val s152 = findViewById<RadioButton>(R.id.ck152)
        val s153 = findViewById<RadioButton>(R.id.ck153)

        val s160 = findViewById<RadioButton>(R.id.ck160)
        val s161 = findViewById<RadioButton>(R.id.ck161)
        val s162 = findViewById<RadioButton>(R.id.ck162)
        val s163 = findViewById<RadioButton>(R.id.ck163)

        val s170 = findViewById<RadioButton>(R.id.ck170)
        val s171 = findViewById<RadioButton>(R.id.ck171)
        val s172 = findViewById<RadioButton>(R.id.ck172)
        val s173 = findViewById<RadioButton>(R.id.ck173)

        val s180 = findViewById<RadioButton>(R.id.ck180)
        val s181 = findViewById<RadioButton>(R.id.ck181)
        val s182 = findViewById<RadioButton>(R.id.ck182)
        val s183 = findViewById<RadioButton>(R.id.ck183)

        val s190 = findViewById<RadioButton>(R.id.ck190)
        val s191 = findViewById<RadioButton>(R.id.ck191)
        val s192 = findViewById<RadioButton>(R.id.ck192)
        val s193 = findViewById<RadioButton>(R.id.ck193)

        val s200 = findViewById<RadioButton>(R.id.ck200)
        val s201 = findViewById<RadioButton>(R.id.ck201)
        val s202 = findViewById<RadioButton>(R.id.ck202)
        val s203 = findViewById<RadioButton>(R.id.ck203)

        val s210 = findViewById<RadioButton>(R.id.ck210)
        val s211 = findViewById<RadioButton>(R.id.ck211)
        val s212 = findViewById<RadioButton>(R.id.ck212)
        val s213 = findViewById<RadioButton>(R.id.ck213)


        val userName = intent.getStringExtra(userId)

        bdi = findViewById(R.id.bdbtn)

        val s1 = arrayOf<RadioButton>(s11,s21,s31,s41,s51,s61,s71,s81,s91,s101,s111,s121,s131,s141,s151,s161,s171,s181,s191,s201,s211)
        val s2 = arrayOf<RadioButton>(s12,s22,s32,s42,s52,s62,s72,s82,s92,s102,s112,s122,s132,s142,s152,s162,s172,s182,s192,s202,s212)
        val s3 = arrayOf<RadioButton>(s13,s23,s33,s43,s53,s63,s73,s83,s93,s103,s113,s123,s133,s143,s153,s163,s173,s183,s193,s203,s213)

        bdi.setOnClickListener {
            var score :Int = 0
            var BdiTotalScore : String = ""

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

            BdiTotalScore = "$score"

//            Toast.makeText(this,"Your total score is $score.",Toast.LENGTH_LONG).show()
            var intent = Intent(this, BDIResult::class.java)
            intent.putExtra("-", BdiTotalScore)
            intent.putExtra(BDIResult.userId,userName)
            startActivity(intent)

        }


    }
}