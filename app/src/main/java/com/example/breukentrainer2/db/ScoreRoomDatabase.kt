package com.example.breukentrainer2.db

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [Score::class],
    version = 1,
    exportSchema = true
)
abstract class ScoreRoomDatabase : RoomDatabase() {

    abstract fun scoreDao(): ScoreDao

    companion object {

        @Volatile
        private var INSTANCE: ScoreRoomDatabase? = null

        fun getDatabase(context: Context): ScoreRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): ScoreRoomDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ScoreRoomDatabase::class.java,
                "scores_database"
            )
                .build()
        }
    }
}