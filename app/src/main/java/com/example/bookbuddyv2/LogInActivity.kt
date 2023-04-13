package com.example.bookbuddyv2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookbuddyv2.ui.theme.BookBuddyV2Theme

class LogInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookBuddyV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SignIn()
                }
            }
        }
    }
}

@Composable
fun SignIn() {

    var userName = remember { mutableStateOf("") }
    val userPassword = remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {


        Column() {
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxSize()
                    .background(colorResource(id = R.color.mantis))
            ) {

            }
            Box(modifier = Modifier.weight(0.5f)){}
            Column(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxSize()
            ) {
            loginButton(userName = "", userPassword = "") {

            }



            }
            //Text(text = "asd", modifier = Modifier.background(colorResource(id = R.color.mantis)))
        }
    }
}

@Composable
fun loginButton(
    userName : String,
    userPassword: String,
    onButtonClick: (String) -> Unit
) {
    val mContext = LocalContext.current
    Column(modifier = Modifier.padding(20.dp)) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.mantis)
            ),
            value = userName,
            onValueChange = onButtonClick,
            label = { Text("User Name")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.mantis)
            ),
            value = userPassword,
            onValueChange = onButtonClick,
            label = { Text("Password") }
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            onClick = {
                //mContext.startActivity(Intent(mContext, LogInActivity::class.java))
                }
        ) {
            Text(
                text = "Log in",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = colorResource(id = R.color.mantis),
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.mantis)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(1.dp, Color.White),
            shape = RoundedCornerShape(10),
            onClick = {
                mContext.startActivity(Intent(mContext, RegisterActivity::class.java))
            }
        ) {
            Text(
                text = "Sign in",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SignIn()
}