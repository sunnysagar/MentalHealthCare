package com.sunny.mentalhealthcare.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sunny.mentalhealthcare.music.AlbumActivity
import com.sunny.mentalhealthtracker.R


class TaskFragment : Fragment() {

    lateinit var wrkMore:TextView
    lateinit var wrkBenefit:LinearLayout
    lateinit var wrkLess:TextView

    lateinit var musicMore:TextView
    lateinit var musicBenefit:LinearLayout
    lateinit var musicLess:TextView
    lateinit var musicExp:TextView

    lateinit var moviesMore:TextView
    lateinit var movieBenefit:LinearLayout
    lateinit var movieLess:TextView

    lateinit var comedyMore:TextView
    lateinit var comedyBenefit:LinearLayout
    lateinit var comedyLess:TextView

    lateinit var lauMore:TextView
    lateinit var lauBenefit:LinearLayout
    lateinit var lauLess:TextView

    lateinit var travelMore:TextView
    lateinit var travelBenefit:LinearLayout
    lateinit var travelLess:TextView

    lateinit var famMore:TextView
    lateinit var famBenefit:LinearLayout
    lateinit var famLess:TextView

    lateinit var friMore:TextView
    lateinit var friBenefit:LinearLayout
    lateinit var friLess:TextView

    lateinit var artsMore:TextView
    lateinit var artsBenefit:LinearLayout
    lateinit var artsLess:TextView

    lateinit var stupidMore:TextView
    lateinit var stupidBenefit:LinearLayout
    lateinit var stupidLess:TextView
    lateinit var stupidLike:TextView
    lateinit var stupidTL:TableLayout
    lateinit var stupidTLess:TextView

    lateinit var readMore:TextView
    lateinit var readBenefit:LinearLayout
    lateinit var readLess:TextView

    lateinit var writeMore:TextView
    lateinit var writeBenefit:LinearLayout
    lateinit var writeLess:TextView

    lateinit var religionMore:TextView
    lateinit var religionBenefit:LinearLayout
    lateinit var religionLess:TextView





    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_task, container, false)

        init(view)

        return view
    }

    fun init(view: View)
    {

        wrkMore = view.findViewById(R.id.wrkMore)
        wrkBenefit = view.findViewById(R.id.wrkBenefit)
        wrkLess = view.findViewById(R.id.wrkClose)

        musicMore = view.findViewById(R.id.musicMore)
        musicBenefit = view.findViewById(R.id.musicBenefit)
        musicLess = view.findViewById(R.id.musicClose)
        musicExp = view.findViewById(R.id.exp1)

        moviesMore = view.findViewById(R.id.movieMore)
        movieBenefit = view.findViewById(R.id.movieBenefit)
        movieLess = view.findViewById(R.id.movieClose)

        comedyMore = view.findViewById(R.id.comedyMore)
        comedyBenefit = view.findViewById(R.id.comedyBenefit)
        comedyLess = view.findViewById(R.id.comedyClose)

        lauMore = view.findViewById(R.id.lauMore)
        lauBenefit = view.findViewById(R.id.lauBenefit)
        lauLess = view.findViewById(R.id.lauClose)

        travelMore = view.findViewById(R.id.travelMore)
        travelBenefit = view.findViewById(R.id.travelBenefit)
        travelLess = view.findViewById(R.id.travelClose)

        famMore = view.findViewById(R.id.famMore)
        famBenefit = view.findViewById(R.id.famBenefit)
        famLess = view.findViewById(R.id.famClose)

        friMore = view.findViewById(R.id.friMore)
        friBenefit = view.findViewById(R.id.friBenefit)
        friLess = view.findViewById(R.id.friClose)

        artsMore = view.findViewById(R.id.artsMore)
        artsBenefit = view.findViewById(R.id.artsBenefit)
        artsLess = view.findViewById(R.id.artsClose)

        stupidMore = view.findViewById(R.id.stupidMore)
        stupidBenefit = view.findViewById(R.id.stupidBenefit)
        stupidTL = view.findViewById(R.id.stupidTL)
        stupidLike = view.findViewById(R.id.stupidLike)
        stupidTLess = view.findViewById(R.id.stupidTLess)

        readMore = view.findViewById(R.id.readMore)
        readBenefit = view.findViewById(R.id.readBenefit)
        readLess = view.findViewById(R.id.readClose)

        writeMore = view.findViewById(R.id.writeMore)
        writeBenefit = view.findViewById(R.id.writeBenefit)
        writeLess = view.findViewById(R.id.writeClose)

        religionMore = view.findViewById(R.id.religionMore)
        religionBenefit = view.findViewById(R.id.religionBenefit)
        religionLess = view.findViewById(R.id.religionClose)



        wrkMore.setOnClickListener {
            wrkBenefit.visibility = View.VISIBLE
            wrkMore.visibility = View.GONE
        }

        wrkLess.setOnClickListener {
            wrkBenefit.visibility = View.GONE
            wrkMore.visibility = View.VISIBLE
        }


        musicMore.setOnClickListener {
            musicBenefit.visibility = View.VISIBLE
            musicMore.visibility = View.GONE
        }
        musicLess.setOnClickListener {
            musicBenefit.visibility = View.GONE
            musicMore.visibility = View.VISIBLE
        }
        musicExp.setOnClickListener {
            startActivity(Intent(activity,AlbumActivity::class.java))
        }

        moviesMore.setOnClickListener {
            movieBenefit.visibility = View.VISIBLE
            moviesMore.visibility = View.GONE
        }
        movieLess.setOnClickListener {
            movieBenefit.visibility = View.GONE
            moviesMore.visibility = View.VISIBLE
        }

        comedyMore.setOnClickListener {
            comedyBenefit.visibility = View.VISIBLE
            comedyMore.visibility = View.GONE
        }
        comedyLess.setOnClickListener {
            comedyBenefit.visibility = View.GONE
            comedyMore.visibility = View.VISIBLE
        }

        lauMore.setOnClickListener {
            lauBenefit.visibility = View.VISIBLE
            lauMore.visibility = View.GONE
        }
        lauLess.setOnClickListener {
            lauBenefit.visibility = View.GONE
            lauMore.visibility = View.VISIBLE
        }

        travelMore.setOnClickListener {
            travelBenefit.visibility = View.VISIBLE
            travelMore.visibility = View.GONE
        }
        travelLess.setOnClickListener {
            travelBenefit.visibility = View.GONE
            travelMore.visibility = View.VISIBLE
        }

        famMore.setOnClickListener {
            famBenefit.visibility = View.VISIBLE
            famMore.visibility = View.GONE
        }
        famLess.setOnClickListener {
            famBenefit.visibility = View.GONE
            famMore.visibility = View.VISIBLE
        }

        friMore.setOnClickListener {
            friBenefit.visibility = View.VISIBLE
            friMore.visibility = View.GONE
        }
        friLess.setOnClickListener {
            friBenefit.visibility = View.GONE
            friMore.visibility = View.VISIBLE
        }

        artsMore.setOnClickListener {
            artsBenefit.visibility = View.VISIBLE
            artsMore.visibility = View.GONE
        }
        artsLess.setOnClickListener {
            artsBenefit.visibility = View.GONE
            artsMore.visibility = View.VISIBLE
        }

        stupidMore.setOnClickListener {
            stupidBenefit.visibility = View.VISIBLE
            stupidMore.visibility = View.GONE
            stupidLike.visibility = View.VISIBLE
        }
        stupidLike.setOnClickListener {
            stupidBenefit.visibility = View.VISIBLE
            stupidMore.visibility = View.GONE
            stupidTL.visibility = View.VISIBLE
            stupidLike.visibility = View.GONE
        }
        stupidTLess.setOnClickListener {
            stupidBenefit.visibility = View.GONE
            stupidMore.visibility = View.VISIBLE
            stupidTL.visibility = View.GONE
        }

        readMore.setOnClickListener {
            readBenefit.visibility = View.VISIBLE
            readMore.visibility = View.GONE
        }
        readLess.setOnClickListener {
            readBenefit.visibility = View.GONE
            readMore.visibility = View.VISIBLE
        }

        writeMore.setOnClickListener {
            writeBenefit.visibility = View.VISIBLE
            writeMore.visibility = View.GONE
        }
        writeLess.setOnClickListener {
            writeBenefit.visibility = View.GONE
            writeMore.visibility = View.VISIBLE
        }

        religionMore.setOnClickListener {
            religionBenefit.visibility = View.VISIBLE
            religionMore.visibility = View.GONE
        }
        religionLess.setOnClickListener {
            religionBenefit.visibility = View.GONE
            religionMore.visibility = View.VISIBLE
        }

    }

}