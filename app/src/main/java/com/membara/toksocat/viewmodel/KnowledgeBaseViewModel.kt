package com.membara.toksocat.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.membara.toksocat.db.KnowledgeBaseDatabase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class KnowledgeBaseViewModel(application: Application) :
    BaseViewModel(application) {

    private val disposable = CompositeDisposable()

    // live data
    val list = MutableLiveData<List<String>>()

    // fetching data from db
    fun getDataByCategory(category: String) {
        launch {
            val dao = KnowledgeBaseDatabase(getApplication()).kbDao()

            if (category == "symptoms") {
                val symptomText = dao.getSymptoms().map {
                    async {
                        it.text
                    }
                }.awaitAll()

                list.value = symptomText
            } else {
                val diseaseText = dao.getDiseases().map {
                    async {
                        it.text
                    }
                }.awaitAll()

                list.value = diseaseText
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}