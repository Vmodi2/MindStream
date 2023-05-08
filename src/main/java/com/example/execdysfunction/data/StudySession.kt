package com.example.execdysfunction.data

data class StudySession(
    val id: Long,
    val startTime: Long,
    val duration: Long,
    val endTime: Long?,
    val isFocused: Boolean,
    val reasonForUnfocused: String?
)