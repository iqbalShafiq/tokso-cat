package com.membara.toksocat.util

import com.membara.toksocat.data.Disease
import com.membara.toksocat.data.Symptom

class InitiateDataUtil {

    companion object {
        fun initiateDataDisease(): MutableList<Disease> {
            val diseases = mutableListOf<Disease>()
            diseases.add(Disease("Tidak mengalami Penyakit Toksoplasmosis"))
            diseases.add(Disease("Toksoplasma Kongenital"))
            diseases.add(Disease("Toksoplasma Kongenital Asymptomatik"))
            diseases.add(Disease("Toksoplasma Akuista\n"))

            return diseases
        }

        fun initiateDataSymptom(): MutableList<Symptom> {
            val symptoms = mutableListOf<Symptom>()
            val diseases = initiateDataDisease()

            // First, add all symptoms text
            symptoms.add(Symptom("Keguguran berulangggg?"))
            symptoms.add(Symptom("Bayi lahir mati?"))
            symptoms.add(Symptom("Kelainan pada mata?"))
            symptoms.add(Symptom("Demam?"))
            symptoms.add(Symptom("Hidrosefalus?"))
            symptoms.add(Symptom("Pembengkakan pada organ hati?"))
            symptoms.add(Symptom("Penyakit  kuning?"))
            symptoms.add(Symptom("Klasifikasi Intrakrananial?"))
            symptoms.add(Symptom("Kemunduran mental?"))
            symptoms.add(Symptom("Kejang pada otot?"))
            symptoms.add(Symptom("Pembengkakan kelenjar getah bening?"))
            symptoms.add(Symptom("Memakan makanan mentah?"))
            symptoms.add(Symptom("Memelihara kucing?"))
            symptoms.add(Symptom("Pneumnia?"))
            symptoms.add(Symptom("Splenomegali?"))

            // Then, add their next destination
            symptoms[0].yesDestination = symptoms[1].text
            symptoms[0].noDestination = null

            return symptoms
        }
    }
}