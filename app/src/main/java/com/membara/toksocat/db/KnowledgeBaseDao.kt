package com.membara.toksocat.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.membara.toksocat.data.Disease
import com.membara.toksocat.data.Symptom

@Dao
interface KnowledgeBaseDao {
    /** Symptom */
    // Insert symptom
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSymptom(vararg symptoms: Symptom): List<Long>

    // Get list of symptom
    @Query("SELECT * FROM symptom")
    suspend fun getSymptoms(): List<Symptom>

    // Get symptom by text
    @Query("SELECT * FROM symptom WHERE text = :text")
    suspend fun getSymptomById(text: Int): Symptom

    // Delete all symptom
    @Query("DELETE FROM symptom")
    suspend fun deleteAllSymptom()

    // Delete symptom by id
    @Query("DELETE FROM symptom WHERE text = :text")
    suspend fun deleteSymptomById(text: Int)

    /** Disease */
    // Insert symptom
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDisease(vararg diseases: Disease): List<Long>

    // Get list of symptom
    @Query("SELECT * FROM disease")
    suspend fun getDiseases(): List<Disease>

    // Get disease by Id
    @Query("SELECT * FROM disease WHERE text = :text")
    suspend fun getDiseaseById(text: Int): Disease

    // Delete all disease
    @Query("DELETE FROM disease")
    suspend fun deleteAllDisease()

    // Delete disease by id
    @Query("DELETE FROM disease WHERE text = :text")
    suspend fun deleteDiseaseById(text: Int)
}