package com.example.suitmedia.presentasion.screen1

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.suitmedia.R
import com.example.suitmedia.presentasion.datastore.StoreName
import com.example.suitmedia.presentasion.navigation.Screen
import kotlinx.coroutines.launch


@Composable
fun firstScreen(
    navController: NavHostController
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = StoreName(context)
    val savedName = dataStore.getName.collectAsState(initial = "")

    var nameValue by remember {
        mutableStateOf(savedName.value!!)
    }

    var isPallindrome by remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    )
    {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Image(
                modifier = Modifier
                    .size(116.dp)
                    .padding(bottom = 51.dp),
                painter = painterResource(id = R.drawable.ic_baseline_person),
                contentDescription = "background"
            )

            TextField(modifier = Modifier
                .fillMaxWidth(),
                value = nameValue,
                onValueChange = {
                    nameValue = it
                }, label = {
                    Text(text = "Name")
                },
                maxLines = 1,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.grey)
                )
            )

            TextField(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp),
                value = isPallindrome,
                onValueChange = {
                    isPallindrome = it
                }, label = {
                    Text(text = "Pallindrome")
                },
                maxLines = 1,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.grey)
                )
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.bluebutton),
                    contentColor = colorResource(id = R.color.white)
                ),
                onClick = {
                    Toast.makeText(context, CheckPalindrom(isPallindrome), Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(12.dp)
            )
            {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 4.dp),
                    text = "CHECK"
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.bluebutton),
                    contentColor = colorResource(id = R.color.white)
                ),
                onClick = {
                    scope.launch {
                        dataStore.saveName(nameValue)
                    }
                    navController.navigate(
                        route = Screen.screen2.route
                    )
                },
                shape = RoundedCornerShape(12.dp)
            )
            {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 4.dp),
                    text = "NEXT"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun firstScreenPreview() {
    firstScreen(navController = rememberNavController())
}