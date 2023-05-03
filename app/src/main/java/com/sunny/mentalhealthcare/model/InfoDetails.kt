package com.sunny.mentalhealthcare.model

data class InfoDetails(
    var patientName:String?=null,
    var patientAge:String?=null,
    val patientMobile:String?=null,
    val patientEmail: String?=null,
    val patientJob: String?=null,
    val patientCity: String?=null,
    val patientState: String?=null,
    val patientGender: String?=null,
    val patientMaritalStatus: String?=null,
//    val patientInterestList: List<String>?=null,
    val patientTymOnPhone: String?=null,
    val patientMeetPeople: String?=null,
    val patientFeeling: String?=null,
    val patientFitness: String?=null,
    val patientInterest1: String?=null,
    val patientInterest2: String?=null,

    val patientSymptom1: String?=null,
    val patientSymptom2: String?=null,
    val patientSymptom3: String?=null,
    val patientSymptom4: String?=null,
    val patientSymptom5: String?=null,
    val patientSymptom6: String?=null,
    val patientSymptom7: String?=null,
    val patientSymptom8: String?=null,
    val patientSymptom9: String?=null,
    val patientSymptom10: String?=null,
    val patientSymptom11: String?=null,
    val patientSymptom12: String?=null,

    val patientTestSelection: String? = null,
    val patientTestScore: String? = null,
    val patientDepressionLevel: String? = null


)
