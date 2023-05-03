package com.sunny.mentalhealthcare.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.sunny.mentalhealthcare.fragment.DoctorsConsult
import com.sunny.mentalhealthcare.fragment.ExerciseYoga
import com.sunny.mentalhealthtracker.R

class TrialActivity : AppCompatActivity() {
    lateinit var frame : FrameLayout
    lateinit var coordinator: CoordinatorLayout
    lateinit var drawer: DrawerLayout
    lateinit var navigationview: NavigationView
    lateinit var toolbar: Toolbar

    var previousMenuItem: MenuItem?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trial)



        frame = findViewById(R.id.frame)
        coordinator = findViewById(R.id.coordinatorLayout)
        drawer = findViewById(R.id.drawerLayout)
        navigationview = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)
        setUpToolbar()

        //adding open and closing funtion of hamburger icon
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@TrialActivity,
            drawer,
            R.string.nav_open,
            R.string.nav_close)

        //adding click listener to hamburger icon
        drawer.addDrawerListener(actionBarDrawerToggle)
        //sync to convert hamburger icon to back icon and vice versa
        actionBarDrawerToggle.syncState()

        //set up the navigation listener
        navigationview.setNavigationItemSelectedListener {

            if(previousMenuItem != null)
                previousMenuItem?.isChecked = false

            it.isCheckable = true
            it.isChecked = true

            previousMenuItem = it

            when(it.itemId)
            {
                R.id.docs-> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,DoctorsConsult())
                        .addToBackStack("Doctors")
                        .commit()

                    supportActionBar?.title = "Doctor Consult"
                    drawer.closeDrawers()
//                    Toast.makeText(this, "Doctor Consult",Toast.LENGTH_SHORT).show()
                }
                R.id.yoga-> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ExerciseYoga())
                        .addToBackStack("Yoga")
                        .commit()
                    supportActionBar?.title = "Exercise & Yoga"
                    drawer.closeDrawers()
                }
            }

            return@setNavigationItemSelectedListener true
        }




    }

   private fun setUpToolbar() {
       setSupportActionBar(toolbar)
       supportActionBar?.title = "Toolbar Title"

       //Hamburger icon adding method
       supportActionBar?.setHomeButtonEnabled(true)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if(id==android.R.id.home)
        {
            drawer.openDrawer(GravityCompat.START) //it'll open the nav from left of screen
        }
        return super.onOptionsItemSelected(item)
    }


}