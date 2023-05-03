package com.sunny.mentalhealthcare.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sunny.mentalhealthcare.activity.CheckUp
import com.sunny.mentalhealthcare.activity.MainActivity
import com.sunny.mentalhealthtracker.R

class HomeFragment : Fragment() {

    lateinit var tense : Button
    lateinit var intr : Button
    lateinit var nott : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        tense = view.findViewById(R.id.feel)
        intr = view.findViewById(R.id.interest)
        nott = view.findViewById(R.id.not_worry)

        /* getting string from activity CheckUp */
        val activity: CheckUp? = activity as CheckUp?
        val myUsername: String? = activity?.getMyData()

        tense.setOnClickListener {
            nott.text = "Nothing to worry ! It's usual thing. Relax and do not overthink."
        }


        intr.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra(MainActivity.userId,myUsername)
            startActivity(intent)
        }

        return view
    }


}