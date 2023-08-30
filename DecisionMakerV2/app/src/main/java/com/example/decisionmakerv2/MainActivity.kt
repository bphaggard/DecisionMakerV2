package com.example.decisionmakerv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.decisionmakerv2.ui.home.HomeScreen
import com.example.decisionmakerv2.ui.theme.DecisionMakerV2Theme
import com.example.decisionmakerv2.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeViewModel: HomeViewModel by viewModels()

        setContent {
            DecisionMakerV2Theme {
                HomeScreen(homeViewModel)
            }
        }
    }
}