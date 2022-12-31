package com.example.brikowassignment.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brikowassignment.R

@Preview
@Composable
fun AddVehicleScreen() {
    val vehicles = listOf(
        R.drawable.automobile,
        R.drawable.rickshaw,
        R.drawable.bycicle,
    )
    val timeStamps = listOf(
        "Monthly", "Weekly", "24 H"
    )
    var vehicleNumber by remember {
        mutableStateOf("")
    }
    Scaffold(topBar = {CustomTopBar()}, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFfafafa))
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            TextField(modifier = Modifier.fillMaxWidth(),
                value = vehicleNumber,
                onValueChange = { vehicleNumber = it },
                placeholder = {
                    Text(
                        text = "User Vehicle no."
                    )
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.DirectionsCar, contentDescription = "")
                },
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
                )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                vehicles.forEach {
                    Button(
                        onClick = { },
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 5.dp
                        ),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .height(48.dp)
                                .width(48.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                timeStamps.forEach {
                    Button(
                        onClick = { },
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 5.dp
                        ),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Text(text = it)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                elevation = 3.dp,
                shape = RoundedCornerShape(3.dp)
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Price: \u20B9 0.0",
                    modifier = Modifier
                        .padding(15.dp)
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                onClick = { },
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Text(text = "BHIMA", modifier = Modifier.padding(5.dp))
            }

            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                onClick = { },
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Text(text = "Book", modifier = Modifier.padding(5.dp))
            }

        }
    }
}
@Composable
private fun CustomTopBar() {
    TopAppBar(
        title = { Text(text = "Add Vehicle", color = Color.White) },
        backgroundColor = Color(0xFF6200ee),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Color.White
            )
        },
    )
}
