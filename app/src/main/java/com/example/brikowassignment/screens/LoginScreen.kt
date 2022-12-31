package com.example.brikowassignment.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brikowassignment.R

@Preview
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.login_bg), contentDescription = "")
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            TopIcon()
            LoginCard(
                Modifier.padding(horizontal = 40.dp)
            )
            MultiStyleText(
                text1 = "No Account ? ",
                color1 = Color(0xFF4700a4),
                text2 = "Create new one",
                color2 = Color(0xFF4700a4)
            )
        }

    }
}

@Composable
fun MultiStyleText(text1: String, color1: Color, text2: String, color2: Color) {
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(color = color1)) {
            append(text1)
        }
        withStyle(style = SpanStyle(color = color2, fontWeight = FontWeight.Bold)) {
            append(text2)
        }
    })
}

@Preview
@Composable
fun TopIcon() {
    Box(
    ) {
        Icon(
            modifier = Modifier
                .offset(3.dp, 2.dp)
                .clip(RoundedCornerShape(20.dp)),
            painter = painterResource(id = R.drawable.awto_icon),
            contentDescription = "",
            tint = Color.Gray
        )
        Icon(
            modifier = Modifier.clip(RoundedCornerShape(20.dp)),
            painter = painterResource(id = R.drawable.awto_icon),
            contentDescription = "",
            tint = Color.Unspecified
        )
    }

}

@Composable
fun LoginCard(modifier: Modifier) {
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(25.dp),
        elevation = 12.dp,
    ) {
        Column(
            modifier = Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(45.dp)
        ) {
            Text(text = "Login Account", fontSize = 25.sp)
            TextField(value = emailState, onValueChange = {emailState = it}, label = {
                Text(
                    text = "E-Mail"
                )
            },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            TextField(
                value = passwordState,
                onValueChange = {passwordState = it},
                label = {
                    Text(
                        text = "Password"
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25.dp),
            ) {
                Text(
                    text = "LOGIN",
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 50.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}
