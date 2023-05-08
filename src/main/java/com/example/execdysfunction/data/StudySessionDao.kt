package com.example.execdysfunction.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudySessionDao {
    @Query("SELECT * FROM StudySession")
    fun getAllStudySessions(): List<StudySession>

    @Insert
    fun insertStudySession(studySession: StudySession): Long
}
