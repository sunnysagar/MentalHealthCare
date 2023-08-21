package com.sunny.mentalhealthcare.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.sunny.mentalhealthcare.fragment.*
import com.sunny.mentalhealthcare.loginClass.LoginActivity
import com.sunny.mentalhealthcare.testClass.CheckUp
import com.sunny.mentalhealthtracker.R
import kotlinx.coroutines.NonCancellable

class AfterTestActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var coordinator : CoordinatorLayout
    lateinit var navigationView: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    var previousMenuItem : MenuItem? = null

    lateinit var mauth: FirebaseAuth
    lateinit var database: DatabaseReference

    var myUser : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_test)

        mauth = FirebaseAuth.getInstance()
        val user = mauth.currentUser
        val emailId = user!!.email
        val uId = user.uid

        init()

        // This  method is also user created to setup the toolbar
        setUpToolbar()

        //user created method to handle the action bar drawer toogle
        setupActionBarToggle(uId,emailId)

        /*This is method is created to display the home fragment inside the activity by default*/
        displayHome2()

//        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, com.sunny.mentalhealthtracker.R.string.nav_open, com.sunny.mentalhealthtracker.R.string.nav_close)
//
//        // pass the Open and Close toggle for the drawer layout listener
//        // to toggle the button
//        drawerLayout.addDrawerListener(actionBarDrawerToggle)
//        actionBarDrawerToggle.syncState()


        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        // geeting and setting the string data for the further process
        val userName = intent.getStringExtra(CheckUp.userId)
        myUser = userName.toString()





//         Below we handle the click listerners of the menu items inside the navigation drawer
        navigationView.setNavigationItemSelectedListener {

            /*Unchecking the previous menu item when a new item is clicked*/
            if(previousMenuItem != null)
                previousMenuItem?.isChecked = false

            /*Highlighting the new menu item, the one which is clicked*/
            it.isCheckable = true
            it.isChecked = true

            /*This sets the value of previous menu item as the current one*/
            previousMenuItem = it

            val mPendingRunnable = Runnable{
                drawerLayout.closeDrawer(GravityCompat.START) }
            android.os.Handler().postDelayed(mPendingRunnable,100)
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            when(it.itemId) {

                /*Opening the home fragment*/
                R.id.main -> {
                    displayHome2()
                    drawerLayout.closeDrawers()
                }

                /*Opening the doctor fragment*/
                R.id.docs -> {

                    val doctorFragment = DoctorsConsult()
                    fragmentTransaction.replace(R.id.frame, doctorFragment)
                    fragmentTransaction.commit()

                    supportActionBar?.title = "Doctor & Counsellor"
                    drawerLayout.closeDrawers()

                }

                /*Opening the task fragment*/
                R.id.task -> {
                    val taskFragment = TaskFragment()
                    fragmentTransaction.replace(R.id.frame,taskFragment)
//                        .addToBackStack("Yoga")
                    fragmentTransaction.commit()

                    supportActionBar?.title = "Task & Activities"
                    drawerLayout.closeDrawers()

                }

                /*Opening the yoga fragment*/
                R.id.yoga -> {
                    val exerciseFragment = ExerciseYoga()
                    fragmentTransaction.replace(R.id.frame,exerciseFragment)
//                        .addToBackStack("Yoga")
                    fragmentTransaction.commit()

                    supportActionBar?.title = "Exercise & Yoga"
                    drawerLayout.closeDrawers()

                }

                /*Exiting the application*/
                R.id.logout -> {
                    mauth.signOut()
                    Toast.makeText(this,"Thank You", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, LoginActivity::class.java))
                    finish()
                }
            }

            return@setNavigationItemSelectedListener true
        }



    }


    private fun setupActionBarToggle(uId: String, emailId: String?) {

        actionBarDrawerToggle = object :
            ActionBarDrawerToggle(this,drawerLayout,
                R.string.nav_open,R.string.nav_close)
        {
            override fun onDrawerStateChanged(newState: Int) {
                super.onDrawerStateChanged(newState)
                val preferences: SharedPreferences = getSharedPreferences("Mental Health Preferences", Context.MODE_PRIVATE)
                val txtUserName = findViewById<TextView>(R.id.txtHeader)
                val txtUserAge = findViewById<TextView>(R.id.txtHeader1)
                val txtUserPhone = findViewById<TextView>(R.id.txtHeader2)
                val txtUserEmail = findViewById<TextView>(R.id.txtHeader3)

                var name:String
                var age:String
                var email:String

                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(uId).addValueEventListener(
                    object: ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            val it = snapshot

                            if(it.exists())
                            {
                                txtUserName.text = it.child("name").value as String
                                txtUserAge.text = it.child("username").child("age").value as String
                                txtUserPhone.text = it.child("username").child("mobile").value as String
                                txtUserEmail.text = emailId.toString()
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            NonCancellable.cancel()
                        }

                    }
                )

                val pendingRunnable = Runnable {
                    val inputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                }
                Handler().postDelayed(pendingRunnable, 50)
            }

        }

        /*Adding the drawer toggle to the drawer layout*/
        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        /*This handles the animation of the hamburger icon when the drawer is opened/closed*/
        actionBarDrawerToggle.syncState()


    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Mental Heatlh Care"

        //Hamburger icon adding method
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun init(){
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        coordinator = findViewById(R.id.coordinatorLayout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /*This is done to open the navigation drawer when the hamburger icon is clicked*/
        if (item.itemId == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun displayHome2(){
        val homeFragment = HomeFragment2()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, homeFragment)
            .commit()
        supportActionBar?.title = "Mental Health Care"
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {

        when(supportFragmentManager.findFragmentById(R.id.frame)){
            !is HomeFragment2 -> HomeFragment2()

            else -> super.onBackPressed()
        }
    }

}