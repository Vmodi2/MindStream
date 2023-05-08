package com.example.execdysfunction.data

class StudySessionDaoFake : StudySessionDao {
    private val studySessions = mutableListOf<StudySession>()

    override fun getAllStudySessions(): List<StudySession> {
        return studySessions
    }

    override fun insertStudySession(studySession: StudySession): Long {
        studySessions.add(studySession.copy(id = studySessions.size.toLong() + 1))
        return studySessions.size.toLong()
    }
}
