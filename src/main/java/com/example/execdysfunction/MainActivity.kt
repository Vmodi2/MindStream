package com.example.execdysfunction

//import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.execdysfunction.data.AppDatabase
import com.example.execdysfunction.data.MainViewModel
import com.example.execdysfunction.data.MainViewModelFactory
import com.example.execdysfunction.ui.components.MainScreen
import com.example.execdysfunction.ui.components.StudySessionsHistory

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(AppDatabase.getInstance(this).studySessionDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp(mainViewModel)
        }
    }
}

@Composable
fun MyApp(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen(mainViewModel, currentHeartRate = null) // Pass the current heart rate here
        }
        composable("study_sessions_history") {
            StudySessionsHistory(mainViewModel)
        }
    }
}
