package com.example.gothouses.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gothouses.models.House
import com.example.gothouses.navigation.Route
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HouseDetail(
    navController: NavHostController,
    house: House,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.LightGray,
            shape = RoundedCornerShape(corner = CornerSize(5.dp))
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(text = "Name", style = MaterialTheme.typography.subtitle1)
                    house.name?.let { Text(text = it, style = MaterialTheme.typography.h6) }
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = "Region", style = MaterialTheme.typography.subtitle1)
                    house.region?.let { Text(text = it, style = MaterialTheme.typography.caption) }
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = "Coat Of Arms", style = MaterialTheme.typography.subtitle1)
                    house.coatOfArms?.let { Text(text = it, style = MaterialTheme.typography.caption) }
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = "Words", style = MaterialTheme.typography.subtitle1)
                    house.words?.let { Text(text = it, style = MaterialTheme.typography.caption) }
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = "Titles", style = MaterialTheme.typography.subtitle1)
                    house.titles?.forEach { title ->
                        Text(text = title, style = MaterialTheme.typography.caption)
                    }
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = "Seats", style = MaterialTheme.typography.subtitle1)
                    house.seats?.forEach { seat ->
                        Text(text = seat, style = MaterialTheme.typography.caption)
                    }
                }
            }
        }

        Button(onClick = {
            navController.navigate(Route.HomePage)
        }) {
            Text(text = "Get Back")
        }
    }
}