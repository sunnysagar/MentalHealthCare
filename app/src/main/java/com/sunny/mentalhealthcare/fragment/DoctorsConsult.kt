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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.sunny.mentalhealthtracker.R
import java.util.*
import javax.mail.*
import javax.mail.internet.AddressException
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class DoctorsConsult : Fragment() {

    lateinit var btnBA:Button
    lateinit var btnBooked:Button
    lateinit var YDocs:TextView
    lateinit var YDocsAns:ImageView

    lateinit var mauth : FirebaseAuth
    lateinit var database : DatabaseReference


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_doctors_consult, container, false)

        mauth = FirebaseAuth.getInstance()

//        val emailId = user!!.email

        btnBA = view.findViewById(R.id.bAp)
        btnBooked = view.findViewById(R.id.btnBooked)
        YDocs = view.findViewById(R.id.ydcs)
        YDocsAns = view.findViewById(R.id.yDocsAns)

        btnBA.setOnClickListener {

            Toast.makeText(activity,"I will Contact you Soon!! ",Toast.LENGTH_SHORT).show()
            btnBA.visibility = View.GONE
            btnBooked.visibility = View.VISIBLE

            buttonSendEmail(view)
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

   /* fun buttonSendEmail(view: View) {

        val user = mauth.currentUser
        val emailId = user!!.email

        try {
//            val stringSenderEmail = "mentalcareteam79@gmail.com"
            val stringSenderEmail = "mentalcareteam07@gmail.com"
            val stringReceiverEmail = "sunnysagar620@gmail.com"
            val stringPasswordSenderEmail = "ufjmswouecpgzlgh"
//            val stringPasswordSenderEmail = "facqupzfqfkrrntz"

            val stringHost = "smtp.gmail.com"

            val properties = Properties()

            properties["mail.smtp.host"] = stringHost
            properties["mail.smtp.port"] = "465"
            properties["mail.smtp.ssl.enable"] = "true"
            properties["mail.smtp.auth"] = "true"

            val session = Session.getInstance(properties, object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail)
                }
            })

            val mimeMessage = MimeMessage(session)
            mimeMessage.addRecipient(Message.RecipientType.TO, InternetAddress(stringReceiverEmail))

            mimeMessage.subject = "Subject: Appointment Notification"
            mimeMessage.setText(
                "Hello, \n\n Hope you are doing well! " +
                        "\n\n contact your new patient ${emailId} as soon as possible. " +
                        "\n\n Thank you!\n Mental Health care Team"
            )

            val thread = Thread {
                try {
                    Transport.send(mimeMessage)
                } catch (e: MessagingException) {
                    e.printStackTrace()
                }
            }
            thread.start()

        } catch (e: AddressException) {
            e.printStackTrace()
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    } */

    fun buttonSendEmail(view: View) {
        val user = mauth.currentUser
        val emailId = user!!.email

        try {
//            val stringSenderEmail = "mentalcareteam79@gmail.com"
            val stringSenderEmail = "mentalcareteam07@gmail.com"
            val stringReceiverEmail = "sunnysagar620@gmail.com"
            val stringPasswordSenderEmail = "ufjmswouecpgzlgh"
//            val stringPasswordSenderEmail = "facqupzfqfkrrntz"

            val stringHost = "smtp.gmail.com"

            val properties = Properties()

            properties["mail.smtp.host"] = stringHost
            properties["mail.smtp.port"] = "465"
            properties["mail.smtp.ssl.enable"] = "true"
            properties["mail.smtp.auth"] = "true"

            val session = Session.getInstance(properties, object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail)
                }
            })

            val mimeMessage = MimeMessage(session)
            mimeMessage.addRecipient(Message.RecipientType.TO, InternetAddress(stringReceiverEmail))

            mimeMessage.subject = "Subject: Appointment Notification"
            mimeMessage.setText(
                "Hello, \n\n Hope you are doing well! " +
                        "\n\n contact your new patient ${emailId} as soon as possible. " +
                        "\n\n Thank you!\n Mental Health care Team"
            )

            val thread = Thread {
                try {
                    Transport.send(mimeMessage)
                } catch (e: MessagingException) {
                    e.printStackTrace()
                }
            }
            thread.start()

        } catch (e: AddressException) {
            e.printStackTrace()
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }


}