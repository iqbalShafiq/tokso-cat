package com.membara.toksocat.util

import com.membara.toksocat.data.Disease
import com.membara.toksocat.data.Symptom

class InitiateDataUtil {

    companion object {
        fun initiateDataDisease(): MutableList<Disease> {
            val diseases = mutableListOf<Disease>()
            diseases.add(Disease("Tidak mengalami Penyakit Toksoplasmosis"))
            diseases.add(Disease("Toksoplasma Kongenital"))
            diseases.add(Disease("Toksoplasma Cerebral"))
            diseases.add(Disease("Toksoplasma Okular"))

            return diseases
        }

        fun initiateDataSymptom(): MutableList<Symptom> {
            val symptoms = mutableListOf<Symptom>()
            val diseases = initiateDataDisease()

            // First, add all symptoms text
            symptoms.add(Symptom("Demam"))
            symptoms.add(Symptom("Pembengkakan kelenjar getah bening"))
            symptoms.add(Symptom("Gangguan pendengaran"))
            symptoms.add(Symptom("Keterbelakangan mental"))
            symptoms.add(Symptom("Hidrosefalus / mikrosefalus"))
            symptoms.add(Symptom("Pembengkakan hati"))
            symptoms.add(Symptom("Penyakit  kuning"))
            symptoms.add(Symptom("Kejang"))
            symptoms.add(Symptom("Kebingungan"))
            symptoms.add(Symptom("Sakit kepala"))
            symptoms.add(Symptom("Bicara tidak jelas"))
            symptoms.add(Symptom("Kurang koordinasi tubuh"))
            symptoms.add(Symptom("Kesulitan bernapas"))
            symptoms.add(Symptom("Penglihatan kabur"))
            symptoms.add(Symptom("Melihat benang melayang"))
            symptoms.add(Symptom("Mata merah"))
            symptoms.add(Symptom("Mata nyeri saat digerakan"))
            symptoms.add(Symptom("Fotopsia"))

            // Then, add their next destination
            symptoms[0].yesDestination = symptoms[7].text
            symptoms[0].noDestination = symptoms[1].text

            symptoms[1].yesDestination = symptoms[2].text
            symptoms[1].noDestination = diseases[0].text

            symptoms[2].yesDestination = symptoms[3].text
            symptoms[2].noDestination = diseases[0].text

            symptoms[3].yesDestination = symptoms[4].text
            symptoms[3].noDestination = diseases[0].text

            symptoms[4].yesDestination = symptoms[5].text
            symptoms[4].noDestination = diseases[0].text

            symptoms[5].yesDestination = symptoms[6].text
            symptoms[5].noDestination = diseases[0].text

            symptoms[6].yesDestination = diseases[1].text
            symptoms[6].noDestination = diseases[0].text

            symptoms[7].yesDestination = symptoms[8].text
            symptoms[7].noDestination = symptoms[13].text

            symptoms[8].yesDestination = symptoms[9].text
            symptoms[8].noDestination = diseases[0].text

            symptoms[9].yesDestination = symptoms[10].text
            symptoms[9].noDestination = diseases[0].text

            symptoms[10].yesDestination = symptoms[11].text
            symptoms[10].noDestination = diseases[0].text

            symptoms[11].yesDestination = symptoms[12].text
            symptoms[11].noDestination = diseases[0].text

            symptoms[12].yesDestination = diseases[2].text
            symptoms[12].noDestination = diseases[0].text

            symptoms[13].yesDestination = symptoms[14].text
            symptoms[13].noDestination = diseases[0].text

            symptoms[14].yesDestination = symptoms[15].text
            symptoms[14].noDestination = diseases[0].text

            symptoms[15].yesDestination = symptoms[16].text
            symptoms[15].noDestination = diseases[0].text

            symptoms[16].yesDestination = symptoms[17].text
            symptoms[16].noDestination = diseases[0].text

            symptoms[17].yesDestination = diseases[3].text
            symptoms[17].noDestination = diseases[0].text

            return symptoms
        }
    }
}