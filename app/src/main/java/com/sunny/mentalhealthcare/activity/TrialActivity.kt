package com.sunny.mentalhealthcare.activity



import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sunny.mentalhealthtracker.R
import java.util.*
import javax.mail.*
import javax.mail.internet.AddressException
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class TrialActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trial)

//        val btn = findViewById<Button>(R.id.button)
//
//        btn.setOnClickListener {
//
//        }
    }

    fun buttonSendEmail(view: View) {
        try {
            val stringSenderEmail = "sunny.btech.cs19@iiitranchi.ac.in"
            val stringReceiverEmail = "sunnysagar620@gmail.com"
            val stringPasswordSenderEmail = "sunnysagar2789"

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
                "Hello, \n Hope you are doing well! " +
                        "\n\n contact your new patient as soon as possible " +
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
