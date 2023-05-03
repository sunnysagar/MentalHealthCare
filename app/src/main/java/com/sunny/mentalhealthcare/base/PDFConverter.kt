package com.sunny.mentalhealthcare.base

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.FileProvider
import com.sunny.mentalhealthcare.model.InfoDetails
import com.sunny.mentalhealthtracker.R
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class PDFConverter {

    private fun createBitmapFromView(
        context: Context,
        view1:View,
        infoDetails: InfoDetails,
        activity: Activity
    ): Bitmap {

        val pName = view1.findViewById<TextView>(R.id.lrName)
        val pAge = view1.findViewById<TextView>(R.id.lrAge)
        val pPhone = view1.findViewById<TextView>(R.id.lrPhone)
        val pGen = view1.findViewById<TextView>(R.id.lrGender)
        val pEmail = view1.findViewById<TextView>(R.id.lrEmail)
        val pJob = view1.findViewById<TextView>(R.id.lrJobStas)
        val pMarry = view1.findViewById<TextView>(R.id.lrMarryStatus)
        val pTymOnPhone = view1.findViewById<TextView>(R.id.lrPh)
        val pMeet = view1.findViewById<TextView>(R.id.lrMp)
        val pMood = view1.findViewById<TextView>(R.id.lrMood)
        val pFitness = view1.findViewById<TextView>(R.id.lrFit)
        val pCity = view1.findViewById<TextView>(R.id.lrCity)
        val pState = view1.findViewById<TextView>(R.id.lrState)
        //Interest
        val pInt0 = view1.findViewById<TextView>(R.id.lrI1)
        val pInt1 = view1.findViewById<TextView>(R.id.lrI2)
        //Symptoms
        val pS1 = view1.findViewById<TextView>(R.id.lrMDDS1)
        val pS2 = view1.findViewById<TextView>(R.id.lrMDDS2)
        val pS3 = view1.findViewById<TextView>(R.id.lrMDDS3)
        val pS4 = view1.findViewById<TextView>(R.id.lrMDDS4)
        val pS5 = view1.findViewById<TextView>(R.id.lrMDDS5)
        val pS6 = view1.findViewById<TextView>(R.id.lrMDDS6)
        val pS7 = view1.findViewById<TextView>(R.id.lrMDDS7)
        val pS8 = view1.findViewById<TextView>(R.id.lrMDDS8)
        val pS9 = view1.findViewById<TextView>(R.id.lrMDDS9)
        val pS10 = view1.findViewById<TextView>(R.id.lrMDDS10)
        val pS11 = view1.findViewById<TextView>(R.id.lrMDDS11)
        val pS12 = view1.findViewById<TextView>(R.id.lrMDDS12)
        //tests
        val pTest = view1.findViewById<TextView>(R.id.lrTs)
        val pTestScore = view1.findViewById<TextView>(R.id.lrTestScore)
        val pDepLevel = view1.findViewById<TextView>(R.id.lrLDW)



        pName.text = infoDetails.patientName
        pAge.text = infoDetails.patientAge
        pPhone.text = infoDetails.patientMobile
        pGen.text = infoDetails.patientGender
        pEmail.text = infoDetails.patientEmail
        pJob.text = infoDetails.patientJob
        pTymOnPhone.text = infoDetails.patientTymOnPhone
        pMeet.text = infoDetails.patientMeetPeople
        pMood.text = infoDetails.patientFeeling
        pFitness.text = infoDetails.patientFitness
        pMarry.text = infoDetails.patientMaritalStatus
        pCity.text = infoDetails.patientCity
        pState.text = infoDetails.patientState

        //Interest Section
        pInt0.text = infoDetails.patientInterest1
        pInt1.text = infoDetails.patientInterest2

        //Symptoms Section
        pS1.text = infoDetails.patientSymptom1
        pS2.text = infoDetails.patientSymptom2
        pS3.text = infoDetails.patientSymptom3
        pS4.text = infoDetails.patientSymptom4
        pS5.text = infoDetails.patientSymptom5
        pS6.text = infoDetails.patientSymptom6
        pS7.text = infoDetails.patientSymptom7
        pS8.text = infoDetails.patientSymptom8
        pS9.text = infoDetails.patientSymptom9
        pS10.text = infoDetails.patientSymptom10
        pS11.text = infoDetails.patientSymptom11
        pS12.text = infoDetails.patientSymptom12

        //testSection
        pTest.text = infoDetails.patientTestSelection
        pTestScore.text = infoDetails.patientTestScore
        pDepLevel.text = infoDetails.patientDepressionLevel




        return createBitmap(context,view1,activity)

    }

    private fun createBitmap(context: Context,
                             view1: View,
                             activity: Activity
    ): Bitmap {
        val displayMetrics = DisplayMetrics()
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
            context.display?.getRealMetrics(displayMetrics)
            displayMetrics.densityDpi
        }
        else{
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        }
        view1.measure(
            View.MeasureSpec.makeMeasureSpec(
                displayMetrics.widthPixels,View.MeasureSpec.EXACTLY
            ),
            View.MeasureSpec.makeMeasureSpec(
                displayMetrics.heightPixels,View.MeasureSpec.EXACTLY
            )
        )
        view1.layout(0,0,displayMetrics.widthPixels,displayMetrics.heightPixels)
        val bitmap = Bitmap.createBitmap(
            view1.measuredWidth,
            view1.measuredHeight,
            Bitmap.Config.ARGB_8888
        )



        val canvas = Canvas(bitmap)
        view1.draw(canvas)
        //792  1120
        return Bitmap.createScaledBitmap(bitmap,792,1120,true)

    }

    private fun convertBitmapToPdf(bitmap: Bitmap, context: Context) {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(792, 1120, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        page.canvas.drawBitmap(bitmap, 0F, 0F, null)
        pdfDocument.finishPage(page)


        val filePath = File(context.getExternalFilesDir(null), "mentalhealthreport.pdf")
        pdfDocument.writeTo(FileOutputStream(filePath))
        pdfDocument.close()
        renderPdf(context, filePath)
    }

    fun createPdf(
        context: Context,
        infoDetails: InfoDetails,
        activity: Activity
    ) {
        val inflater = LayoutInflater.from(context)
        val view1 = inflater.inflate(R.layout.layout_report_page, null)

        /* For Current Date View */
        val date = view1.findViewById<TextView>(R.id.lrDate)
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val currentDate : String = simpleDateFormat.format(Date())
        date.text = currentDate


        val bitmap = createBitmapFromView(context, view1,infoDetails, activity)
        convertBitmapToPdf(bitmap, activity)
    }

    private fun renderPdf(context: Context, filePath: File) {
        val uri = FileProvider.getUriForFile(
            context,
            context.applicationContext.packageName + ".provider",
            filePath
        )
        val intent = Intent(Intent.ACTION_VIEW)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.setDataAndType(uri, "application/pdf")

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {

        }
    }


}