package com.membara.toksocat.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.membara.toksocat.data.Symptom
import com.membara.toksocat.db.KnowledgeBaseDatabase
import com.membara.toksocat.util.InitiateDataUtil
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : BaseViewModel(application) {
    private val disposable = CompositeDisposable()

    // live data
    val symptoms = MutableLiveData<List<Symptom>>()

    // check db first
    fun checkDB() {
        launch {
            val dao = KnowledgeBaseDatabase(getApplication()).kbDao()

            // check the db
            val results = dao.getSymptoms()
            if (results.isEmpty()) addDummyDataToDB()
            else symptoms.value = results
        }
    }

    private fun addDummyDataToDB() {
        launch {
            val dao = KnowledgeBaseDatabase(getApplication()).kbDao()

            // get dummy data
            val dummySymptoms = InitiateDataUtil.initiateDataSymptom()
            val dummyDisease = InitiateDataUtil.initiateDataDisease()

            // insert all to db
            dummySymptoms.map { symptom ->
                async {
                    dao.insertSymptom(symptom)
                }
            }.awaitAll()

            dummyDisease.map { disease ->
                async {
                    dao.insertDisease(disease)
                }
            }.awaitAll()

            // assign to live data
            symptoms.value = dummySymptoms
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}