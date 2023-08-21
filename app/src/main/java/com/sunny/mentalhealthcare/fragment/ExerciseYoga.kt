package com.sunny.mentalhealthcare.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sunny.mentalhealthcare.funClass.YogaActivity
import com.sunny.mentalhealthtracker.R

class ExerciseYoga : Fragment() {

    lateinit var knowMoreY:TextView
    lateinit var bnLL1:LinearLayout
    lateinit var sexmY:TextView
    lateinit var exmY:TextView
    lateinit var expmY:TextView
    lateinit var close1:TextView

    lateinit var knowMoreS:TextView
    lateinit var bnLL2:LinearLayout
    lateinit var close2:TextView

    lateinit var knowMoreD:TextView
    lateinit var bnLL3:LinearLayout
    lateinit var close3:TextView

    lateinit var knowMoreR:TextView
    lateinit var bnLL4:LinearLayout
    lateinit var close4:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_exercise_yoga, container, false)

        init(view)

        return view
    }

    fun init(view: View)
    {
        knowMoreY = view.findViewById(R.id.km1)
        bnLL1 = view.findViewById(R.id.bnLL1)
        sexmY = view.findViewById(R.id.exmY)
        exmY = view.findViewById(R.id.likY)
        expmY = view.findViewById(R.id.exp1)
        close1 = view.findViewById(R.id.close1)

        knowMoreS = view.findViewById(R.id.km2)
        bnLL2 = view.findViewById(R.id.bnLL2)
        close2 = view.findViewById(R.id.close2)

        knowMoreD = view.findViewById(R.id.km3)
        bnLL3 = view.findViewById(R.id.bnLL3)
        close3 = view.findViewById(R.id.close3)

        knowMoreR = view.findViewById(R.id.km4)
        bnLL4 = view.findViewById(R.id.bnLL4)
        close4 = view.findViewById(R.id.close4)



        knowMoreY.setOnClickListener {
            bnLL1.visibility = View.VISIBLE
            knowMoreY.visibility = View.GONE
            close1.visibility = View.VISIBLE
        }
        sexmY.setOnClickListener {
            exmY.visibility = View.VISIBLE
            expmY.visibility = View.VISIBLE
        }
        expmY.setOnClickListener {
            startActivity(Intent(activity, YogaActivity::class.java))
        }
        close1.setOnClickListener {
            bnLL1.visibility = View.GONE
            knowMoreY.visibility = View.VISIBLE
            close1.visibility = View.GONE
        }

        knowMoreS.setOnClickListener {
            bnLL2.visibility = View.VISIBLE
            knowMoreS.visibility = View.GONE
            close2.visibility = View.VISIBLE
        }
        close2.setOnClickListener {
            bnLL2.visibility = View.GONE
            knowMoreS.visibility = View.VISIBLE
            close2.visibility = View.GONE
        }

        knowMoreD.setOnClickListener {
            bnLL3.visibility = View.VISIBLE
            knowMoreD.visibility = View.GONE
            close3.visibility = View.VISIBLE
        }
        close3.setOnClickListener {
            bnLL3.visibility = View.GONE
            knowMoreD.visibility = View.VISIBLE
            close3.visibility = View.GONE
        }

        knowMoreR.setOnClickListener {
            bnLL4.visibility = View.VISIBLE
            knowMoreR.visibility = View.GONE
            close4.visibility = View.VISIBLE
        }
        close4.setOnClickListener {
            bnLL4.visibility = View.GONE
            knowMoreR.visibility = View.VISIBLE
            close4.visibility = View.GONE
        }



    }

}