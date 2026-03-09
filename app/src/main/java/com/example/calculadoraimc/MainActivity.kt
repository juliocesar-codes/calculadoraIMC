package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculadoraScreem(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CalculadoraScreem(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
//        Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(colorResource(R.color.cor_app)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.bmi),
                contentDescription = "IMC Logo",
                modifier = Modifier.size(80.dp)
                    .padding(vertical = 16.dp)
            )

            Text(
                text = "Calculadora IMC",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
//            Form
            Card(modifier = Modifier
//                .fillMaxWidth()
//                .height(300.dp)
                .size(250.dp)
                .offset(y = -(30).dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF9F6F6)
                ),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = CircleShape,
                border = BorderStroke(width = 4.dp, Color.Black)
                ) {

            }

//            Result
        }
    }
}