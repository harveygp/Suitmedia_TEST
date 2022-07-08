package com.example.suitmedia.presentasion.screen3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.suitmedia.R
import com.example.suitmedia.presentasion.navigation.Screen
import com.example.suitmedia.presentasion.screen3.component.ThirdScreenViewModel
import com.example.suitmedia.presentasion.screen3.component.listUser


@Composable
fun thirdScreen(
    navController: NavHostController,
    viewModel: ThirdScreenViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    )
    {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
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
                        text = "THIRD SCREEN"
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
                                route = Screen.screen2.route
                            )
                        },
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "back button"
                )
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .weight(13f)
        )
        {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(state.Lists) { list ->
                    listUser(data = list,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun thirdScreenPreview() {
    thirdScreen(navController = rememberNavController())
}