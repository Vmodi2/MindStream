package com.example.execdysfunction.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.execdysfunction.data.MainViewModel
import com.example.execdysfunction.data.StudySessionDaoFake

@Composable
fun MainScreen(mainViewModel: MainViewModel, currentHeartRate: Int?) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (currentHeartRate != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$currentHeartRate BPM",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            FloatingActionButton(
                onClick = { /* TODO: Open timer input dialog */ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Start study session")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("No Study Session", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(mainViewModel = MainViewModel(StudySessionDaoFake()), currentHeartRate = 80)
}
