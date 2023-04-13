package com.example.bookbuddyv2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookbuddyv2.ui.theme.BookBuddyV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookBuddyV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginSignup()
                }
            }
        }
    }
}

@Composable
fun LoginSignup(){
    // Fetching the Local Context
    val mContext = LocalContext.current

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(colorResource(id = R.color.mantis))){
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {

            Box(modifier = Modifier.weight(4f)
                .fillMaxSize(),
            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painterResource(id = R.drawable.logonobg),
                        contentDescription = null,
                        )
                }
            }
            Text(
                text = "Book Buddy",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text = "Manage and discover books",
                modifier = Modifier.padding(top = 10.dp),
                color = Color.White,
                fontSize = 16.sp
            )
            Box(modifier = Modifier.weight(0.5f)){}
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier.fillMaxWidth().height(50.dp),
                onClick = {
                    mContext.startActivity(Intent(mContext, LogInActivity::class.java))
                }
            ) {
                Text(
                    text = "Log in",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.mantis),
                )
            }
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.mantis), ),
                modifier = Modifier.fillMaxWidth().padding( vertical = 10.dp).padding(bottom = 80.dp).height(50.dp),
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(10),
                onClick = {
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
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BookBuddyV2Theme {
        LoginSignup()
    }
}