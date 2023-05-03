package com.sunny.mentalhealthcare.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sunny.mentalhealthtracker.R


class DoctorsConsult : Fragment() {

    lateinit var btnBA:Button
    lateinit var btnBooked:Button
    lateinit var YDocs:TextView
    lateinit var YDocsAns:ImageView


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_doctors_consult, container, false)
        btnBA = view.findViewById(R.id.bAp)
        btnBooked = view.findViewById(R.id.btnBooked)
        YDocs = view.findViewById(R.id.ydcs)
        YDocsAns = view.findViewById(R.id.yDocsAns)

        btnBA.setOnClickListener {

            Toast.makeText(activity,"I will Contact you Soon ",Toast.LENGTH_SHORT).show()
            btnBA.visibility = View.GONE
            btnBooked.visibility = View.VISIBLE
        }

        btnBooked.setOnClickListener {

            Toast.makeText(activity,"Thank you",Toast.LENGTH_SHORT).show()
            btnBA.visibility = View.VISIBLE
            btnBooked.visibility = View.GONE
        }

        YDocs.setOnClickListener {
            YDocsAns.visibility = View.VISIBLE
        }






        return view
    }


}