package com.example.lab_07

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.sp

@Composable
fun DriversScreen(navController: NavController) {

    var driverName by remember {mutableStateOf("")}
    var drivers by remember {mutableStateOf(listOf<String>()) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
    ) {
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("homeButton")
        ) {
            Text("Home")
        }

        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = driverName,
                onValueChange = { driverName = it },
                label = { Text("Driver Name") },
                modifier = Modifier
                    .weight(1f)
                    .testTag("driverInput")
            )

            Button(
                onClick = {
                    if (driverName.isNotBlank()) {
                        drivers = drivers + driverName
                        driverName = ""
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .testTag("addDriverButton")
            ) {
                Text("Add")
            }

            Button(
                onClick = {
                    if (drivers.isNotEmpty())
                    drivers = emptyList()
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .testTag("clearDrivers")
            ) {
                Text("Clear")
            }

        }

        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(drivers) {
                driver -> Text(
                    text = driver
                )
            }
        }
    }



}