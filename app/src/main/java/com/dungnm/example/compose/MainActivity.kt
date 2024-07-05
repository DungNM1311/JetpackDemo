package com.dungnm.example.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.dungnm.example.compose.ui.HomeScreen
import com.dungnm.example.compose.ui.base.BaseActivity
import com.dungnm.example.compose.ui.theme.JetPackDemoTheme
import com.dungnm.example.compose.viewmodels.CommonViewModel

class MainActivity : BaseActivity() {

    override val viewModel: CommonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackDemoTheme {
                HomeScreen().Screen(viewModel)
            }
        }
    }
}

