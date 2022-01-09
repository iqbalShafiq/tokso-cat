package com.membara.toksocat.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.membara.toksocat.data.Disease
import com.membara.toksocat.data.Symptom

@Database(
    entities = [Symptom::class, Disease::class],
    version = 2
)
abstract class KnowledgeBaseDatabase : RoomDatabase() {
    abstract fun kbDao(): KnowledgeBaseDao

    companion object {
        @Volatile
        private var instance: KnowledgeBaseDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            KnowledgeBaseDatabase::class.java,
            "knowledgebasedatabase"
        ).fallbackToDestructiveMigration().build()
    }
}