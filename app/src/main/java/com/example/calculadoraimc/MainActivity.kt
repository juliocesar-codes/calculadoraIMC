package com.example.calculadoraimc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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
                modifier = Modifier
                    .size(80.dp)
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

            var altura by remember {
                mutableStateOf(value = "")
            }

            var peso by remember {
                mutableStateOf(value = "")
            }

            var imc by remember {
                mutableStateOf(0.00f)
            }

            var classificacao by remember {
                mutableStateOf("")
            }
//            Form
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .size(250.dp)
                .offset(y = -(30).dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF9F6F6)
                ),
                elevation = CardDefaults.cardElevation(4.dp),
//                shape = CircleShape,
//                border = BorderStroke(width = 4.dp, Color.Black)
                ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Seus Dados",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally),
                        fontSize = 28.sp,
                        color = Color(76, 166, 213),
                        fontWeight = FontWeight.SemiBold
                    )

                    TextField(
                        value = altura,
                        onValueChange = {
                            novoValor: String ->

                            Log.i("Teste", novoValor)

                            altura = novoValor
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = {
                            Text("Altura")
                        },
                        label = {
                            Text("Altura")
                        },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )

                    TextField(
                        value = peso,
                        onValueChange = {
                                novoValor: String ->

                            Log.i("Teste", novoValor)

                            peso = novoValor
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = {
                            Text("Peso")
                        },
                        label = {
                            Text("Peso")
                        },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )

                    Button(
                        onClick = {

                            var alturaFloat = altura.toFloat() / 100
                            var pesoFloat = peso.toFloat()

                            if (altura != "" && peso != "" && alturaFloat > 0 && pesoFloat > 0){

                                imc = pesoFloat / (alturaFloat * alturaFloat)

                                    if (imc < 18.5){
                                        classificacao = "Abaixo do peso"
                                    }else if (imc > 18.5 && imc < 25.0){
                                        classificacao = "Peso ideal"
                                    }else if (imc >= 25 && imc < 30){
                                        classificacao = "Levemente acima do peso"
                                    }else if(imc >= 30 && imc < 35){
                                        classificacao = "Obesidade grau I"
                                    }else if(imc >= 35 && imc < 40){
                                        classificacao = "Obesidade grau II"
                                    }else{
                                        classificacao = "Obesidade grau III"
                                    }

                            }else{
                                classificacao = "Valores Inválidos"
                            }
                        },
                        modifier = Modifier
                            .width(270.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text("Calcular")
                    }
                }
            }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(76, 166, 213)),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = imc.toString(),
                            modifier = Modifier,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Text(
                            text = classificacao,
                            modifier = Modifier,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }

                }

                }
            }

        }