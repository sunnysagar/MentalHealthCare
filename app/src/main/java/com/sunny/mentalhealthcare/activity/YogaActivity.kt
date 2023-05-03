package com.sunny.mentalhealthcare.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.sunny.mentalhealthcare.adapter.ViewPagerAdapter
import com.sunny.mentalhealthcare.yoga.*
import com.sunny.mentalhealthtracker.R

class YogaActivity : AppCompatActivity() {

    lateinit var pager:ViewPager
    lateinit var tab:TabLayout
    lateinit var bar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        bar = findViewById(R.id.toolbar)

        //to make our toolbar show the application
        //we need to give it to the actionBar

        setSupportActionBar(bar)
        supportActionBar?.title = "Yoga Asana"

        //Initializing the viewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)

        //adding fragment in the list
        adapter.addFragment(SukhasanaFragment(),"Easy Pose")
        adapter.addFragment(AdhoMukhaSvanasanaFragment(),"Downward Facing Dog Pose")
        adapter.addFragment(UrdhvaMukhaSvanasanaFragment(),"Upward Facing Dog Pose")
        adapter.addFragment(SarvangasanaFragment(),"Shoulder Stand")
        adapter.addFragment(UttanasanaFragment(),"Standing Forward Fold Pose")
        adapter.addFragment(BalasanaFragment(),"Child's Pose")
        adapter.addFragment(SavasanaFragment(),"Corpse Pose")

        //adding the adapter to the viewPager
        pager.adapter = adapter

        //bind the viewPager with TabLayout
        tab.setupWithViewPager(pager)
    }
}