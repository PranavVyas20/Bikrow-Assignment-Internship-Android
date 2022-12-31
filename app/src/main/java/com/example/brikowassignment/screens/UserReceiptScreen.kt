package com.example.brikowassignment.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brikowassignment.R


private val buttons = listOf("Print", "ADD", "Back")

@Preview
@Composable
fun UserReceiptScreen() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { CustomTopBar() }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.automobile),
                contentDescription = ""
            )
            VehicleDetails()
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                elevation = 3.dp,
                shape = RoundedCornerShape(3.dp)
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Cost: \u20B9 50.0",
                    modifier = Modifier
                        .background(Color(0xFF8661e9))
                        .padding(15.dp)
                )
            }
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                painter = painterResource(id = R.drawable.qr_img), contentDescription = ""
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                buttons.forEach {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8661e9))
                    ) {
                        Text(text = it)
                    }
                }
            }
        }
    }
}

@Composable
private fun CustomTopBar() {
    TopAppBar(
        title = { Text(text = "User Receipt", color = Color.White) },
        backgroundColor = Color(0xFF45009a),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Color.White
            )
        },
    )
}

@Composable
private fun VehicleDetails() {
    Column() {
        Text(text = "Vehicle No.: KA03AC6315")
        Text(text = "In Time: 15/09/2021 1:26 PM")
        Text(text = "Exp Out Time: 15/09/2021 1:26 PM")
        Text(text = "Amount Paid: Rs 50")
    }
}