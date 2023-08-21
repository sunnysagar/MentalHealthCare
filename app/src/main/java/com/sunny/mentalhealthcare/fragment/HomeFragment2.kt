package com.sunny.mentalhealthcare.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.sunny.mentalhealthcare.testClass.BasicDetails
import com.sunny.mentalhealthtracker.R

class HomeFragment2 : Fragment() {

    lateinit var test:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home2, container, false)

        test = view.findViewById(R.id.take)

        test.setOnClickListener {


            val builder = AlertDialog.Builder(activity!!)
            builder.setTitle("we suggest take test on every 15-20days!!")
                .setMessage("really you want to take? ")
                .setPositiveButton("Yes"){_, _ ->
                    startActivity(Intent(activity, BasicDetails::class.java))
                }
                .setNegativeButton("No"){_, _ ->

                    Toast.makeText(activity,"OKAY!! Explore Our APP",Toast.LENGTH_SHORT).show()
                }
                .create()
                .show()
        }

        return  view
    }
}