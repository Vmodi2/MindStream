package com.example.execdysfunction.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.execdysfunction.data.MainViewModel
import com.example.execdysfunction.data.MainViewModelFactory


@Composable
fun StudySessionsHistory(mainViewModel: MainViewModel) {
    // Mock data for preview
    val studySessions = listOf(
        StudySession(
            id = 1,
            startTime = System.currentTimeMillis(),
            duration = 1800000,
            endTime = System.currentTimeMillis() + 1800000,
            isFocused = true,
            reasonForUnfocused = null
        ),
        StudySession(
            id = 2,
            startTime = System.currentTimeMillis() - 86400000,
            duration = 3600000,
            endTime = System.currentTimeMillis() - 86400000 + 3600000,
            isFocused = false,
            reasonForUnfocused = "Feeling tired"
        )
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(studySessions) { studySession ->
            Text("Session ${studySession.id}: ${studySession.duration / 60000} minutes")
            if (studySession.reasonForUnfocused != null) {
                Text("Reason for being unfocused: ${studySession.reasonForUnfocused}")
            }
        }
    }
}

@Preview
@Composable
fun StudySessionsHistoryPreview() {
    StudySessionsHistory(mainViewModel = MainViewModel(StudySessionDaoFake()))
}
