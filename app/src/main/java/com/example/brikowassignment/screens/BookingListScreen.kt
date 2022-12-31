package com.example.brikowassignment.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.QrCodeScanner
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brikowassignment.R


data class VehicleInfo(
    val vehicleNo: String,
    val inTime: String,
    val outTime: String,
    val price: String,
    val paymentMethod: String,
    val vehicleImg: Int
)

private val vehicleItems = listOf<VehicleInfo>(
    VehicleInfo(
        vehicleNo = "TN 01 BC 3402",
        inTime = "8:53 PM",
        outTime = "9:23 PM",
        price = "40",
        paymentMethod = "Cash",
        vehicleImg = R.drawable.bycicle
    ),
    VehicleInfo(
        vehicleNo = "TN 01 BC 3402",
        inTime = "8:53 PM",
        outTime = "9:23 PM",
        price = "40",
        paymentMethod = "Cash",
        vehicleImg = R.drawable.bycicle
    ),
    VehicleInfo(
        vehicleNo = "TN 01 BC 3402",
        inTime = "8:53 PM",
        outTime = "9:23 PM",
        price = "40",
        paymentMethod = "Cash",
        vehicleImg = R.drawable.bycicle
    )
)

@Preview
@Composable
private fun TopBar() {
    TopAppBar(
        title = { Text(text = "Booking List", color = Color.White) },
        backgroundColor = Color(0xFF0083f2),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Color.White
            )
        },
        actions = {
            Icon(imageVector = Icons.Default.QrCodeScanner, contentDescription = "", tint = Color.White)
        }
    )
}

@Preview
@Composable
fun BookingListScreen() {
    Scaffold(topBar = { TopBar() }, modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(15.dp)) {
            SearchBar()
            vehicleItems.forEach {
                VehicleItem(vehicleInfo = it)
            }
        }
    }
}

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            modifier = Modifier
                .weight(0.9f)
                .border(width = 1.dp, color = Color(0xFF0083f2), RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            placeholder = { Text(text = "Search here") },
            value = text,
            onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
        Icon(
            modifier = Modifier
                .weight(0.1f)
                .scale(1.4f),
            imageVector = Icons.Default.Search,
            contentDescription = ""
        )
    }

}

@Composable
fun VehicleItem(vehicleInfo: VehicleInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.LightGray,
        border = BorderStroke(2.dp, color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(58.dp)
                    .clip(RoundedCornerShape(20.dp)),
                painter = painterResource(id = R.drawable.awto_icon),
                contentDescription = "",
                tint = Color.Unspecified
            )
            VehicleInfo(vehicleInfo)
            Icon(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = vehicleInfo.vehicleImg),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
private fun VehicleInfo(vehicleInfo: VehicleInfo) {
    Column() {
        Text(text = "Vehicle No. ${vehicleInfo.vehicleNo}", fontWeight = FontWeight.Bold)
        Text(text = "In Time: ${vehicleInfo.inTime}")
        Text(text = "Out Time: ${vehicleInfo.outTime}")
        Text(text = "Price: ₹ ${vehicleInfo.price}")
        Text(text = "Payment Method: ${vehicleInfo.paymentMethod}", maxLines = 1)
    }
}