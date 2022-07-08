package com.example.suitmedia.presentasion.screen3.component


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.suitmedia.R
import com.example.suitmedia.domain.model.User
import com.example.suitmedia.presentasion.datastore.StoreUsername
import com.example.suitmedia.presentasion.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun listUser(
    data: User,
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore2 = StoreUsername(context)

    var email by remember {
        mutableStateOf(data.email)
    }
    var first by remember {
        mutableStateOf(data.first_name)
    }
    var last by remember {
        mutableStateOf(data.last_name)
    }

    Box(
        modifier = Modifier
            .clickable {
                scope.launch {
                    dataStore2.saveUsername("${data.first_name} ${data.last_name}")
                }
            }
            .fillMaxWidth()
            .padding(20.dp)

    ) {
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data.avatar)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.background),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp),
                contentDescription = "Profile Image"

            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row {
                    Text(
                        text = first,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = last,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = email
                )
            }

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun listUserPreview() {
//    listUser()
//}