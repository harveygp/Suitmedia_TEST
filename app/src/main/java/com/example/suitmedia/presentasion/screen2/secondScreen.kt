package com.example.suitmedia.presentasion.screen2

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.suitmedia.R
import com.example.suitmedia.presentasion.datastore.StoreName
import com.example.suitmedia.presentasion.datastore.StoreUsername
import com.example.suitmedia.presentasion.navigation.Screen

@Composable
fun secondScreen(
    navController: NavHostController
)
{

    val context = LocalContext.current
    val dataStore1 = StoreName(context)
    val savedName = dataStore1.getName.collectAsState(initial = "")
    val dataStore2 = StoreUsername(context)
    val savedUsername = dataStore2.getUsername.collectAsState(initial = "")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    )
    {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .weight(1f))
        {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "SECOND SCREEN",
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Image(
                    modifier = Modifier
                        .padding(start = 28.dp)
                        .fillMaxHeight()
                        .width(35.dp)
                        .clickable {
                            navController.navigate(
                                route = Screen.screen1.route
                            )
                        },
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "back button"
                )
            }
        }
        Surface(modifier = Modifier
            .fillMaxWidth()
            .padding(21.dp)
            .weight(13f)) 
        {
            Column(modifier = Modifier
                .height(40.dp)
                .fillMaxSize())
            {
                Text(text = "Welcome")
                Text(text = savedName.value!!, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                )
                {
                    Text(text = savedUsername.value!!, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)
                }
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp),
                    elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.bluebutton),
                        contentColor = colorResource(id = R.color.white)
                    ),
                    onClick = {
                        navController.navigate(
                            route = Screen.screen3.route
                        )
                              },
                    shape = RoundedCornerShape(12.dp)
                )
                {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 4.dp),
                        text = "Choose a User")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun secondScreenPreview() {
    secondScreen(navController = rememberNavController())
}