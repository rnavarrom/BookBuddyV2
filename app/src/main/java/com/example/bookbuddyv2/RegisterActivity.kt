package com.example.bookbuddyv2

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

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookBuddyV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Register()
                }
            }
        }
    }


@Composable
fun Register() {
    val mContext = LocalContext.current
    var userName = remember { mutableStateOf("") }
    val userPassword = remember { mutableStateOf("") }
    val userEmail = remember { mutableStateOf("") }

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
                RegisterButton(userName = "", userPassword = "", userPassword2 = "", userEmail = "")
                {

                }
            }
            //Text(text = "asd", modifier = Modifier.background(colorResource(id = R.color.mantis)))
        }
    }
}

@Composable
fun RegisterButton(
    userName : String,
    userPassword: String,
    userPassword2: String,
    userEmail: String,
    onButtonClick: (String) -> Unit
) {
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
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.mantis)
            ),
            value = userEmail,
            onValueChange = onButtonClick,
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.mantis)
            ),
            value = userPassword,
            onValueChange = onButtonClick,
            label = { Text("Password") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.mantis)
            ),
            value = userPassword2,
            onValueChange = onButtonClick,
            label = { Text("Repeat Password") }
        )
        Spacer(modifier = Modifier.height(20.dp))
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
                text = "Register",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = colorResource(id = R.color.mantis),
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Register()
}
}