/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Author: Irving Acosta - 22781
 * Description: Healthy Living App, list Manipulation with Compose
 */

package com.example.laboratorio04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio04.ui.theme.Laboratorio04Theme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //Estableciendo la interfaz de usuario de la aplicación usando JetPack
            Laboratorio04Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen() // Llamando al composable MainScreen en su lugar
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var itemName by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    val itemList = remember { mutableStateListOf<Item>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Nombre del elemento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        TextField(
            value = imageUrl,
            onValueChange = { imageUrl = it },
            label = { Text("URL de la imagen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                if (itemName.isNotEmpty() && imageUrl.isNotEmpty()) {
                    itemList.add(Item(itemName, imageUrl))
                    itemName = ""
                    imageUrl = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Agregar")
        }

        LazyColumn {
            items(itemList) { item ->
                CustomListItem(item)
            }
        }
    }
}

data class Item(val name: String, val imageUrl: String)

@Composable
fun CustomListItem(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)  // Cambiado a 8.dp o el valor que prefieras
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(item.imageUrl),
                contentDescription = "Imagen del elemento",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = item.name)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio04Theme {
        MainScreen() // Llamando al composable MainScreen en su lugar
    }
}
