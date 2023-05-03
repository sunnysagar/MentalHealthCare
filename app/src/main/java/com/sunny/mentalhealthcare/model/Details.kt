package com.sunny.mentalhealthcare.model

data class Details(
    val name: String = "",
    val age: String= "",
    var mobile: String = "",
    val email: String?= "",
    val job: String= "",
    val city: String= "",
    val state: String= "",
    val gender: String= "",
    val maritalStatus: String= "",
    val tymOnPhone: String= "",
    val meetPeopleCount: String= "",
    val todaySMood: String= "",
    val fitness: String= "",
    //Interest Section
    val interest1 : String = "",
    val interest2: String = "",

//    val interestList:MutableMap<String,String> = mutableMapOf(),
//    val interestList:Interest,

    //Symptoms Section
    val symptom1: String="",
    val symptom2: String="",
    val symptom3: String="",
    val symptom4: String="",
    val symptom5: String="",
    val symptom6: String="",
    val symptom7: String="",
    val symptom8: String="",
    val symptom9: String="",
    val symptom10: String="",
    val symptom11: String="",
    val symptom12: String="",

    //Test Section
    val test0Selected:String = "",
    val test1Score : String = "",
    val Test2DepressionLevel : String = ""


    )
