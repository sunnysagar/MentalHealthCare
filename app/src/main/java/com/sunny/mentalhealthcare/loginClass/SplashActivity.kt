package com.sunny.mentalhealthcare.loginClass

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.sunny.mentalhealthcare.activity.AfterTestActivity
import com.sunny.mentalhealthtracker.R


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    lateinit var video : VideoView
    lateinit var mAuth:FirebaseAuth
    lateinit var currentUser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        window.statusBarColor = Color.parseColor("#FFFFFFFF")

        mAuth = FirebaseAuth.getInstance()

//        currentUser = mAuth.currentUser!!

        video = findViewById(R.id.vid)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)


        val offlineUrl : Uri = Uri.parse("android.resource://$packageName/${R.raw.splash}")

        video.setMediaController(mediaController)

        video.setVideoURI(offlineUrl)
        video.requestFocus()
        video.start()

        Handler().postDelayed ({
            val user = mAuth.currentUser
            if(user==null)
            {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this@SplashActivity, AfterTestActivity::class.java)
//                val intent = Intent(this@SplashActivity, TrialActivity::class.java)
                startActivity(intent)
                finish()
            }
        },1500)
    }
}