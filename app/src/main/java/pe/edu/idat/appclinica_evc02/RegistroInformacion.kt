package pe.edu.idat.appclinica_evc02

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Registro(navController: NavHostController) {
    var casilla1 by rememberSaveable { mutableStateOf("") }
    var casilla2 by rememberSaveable { mutableStateOf("") }
    var seleccionarSexo by rememberSaveable { mutableStateOf("Hombre") }
    var deporteChecked by rememberSaveable { mutableStateOf(false) }
    var pinturaChecked by rememberSaveable { mutableStateOf(false) }
    var otroChecked by rememberSaveable { mutableStateOf(false) }
    var vistalibros by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Información",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                style = TextStyle(
                    fontSize = 30.sp,
                    color = Color.Black
                )
            )

            OutlinedTextField(
                value = casilla1,
                onValueChange = { casilla1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("DNI", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = casilla2,
                onValueChange = { casilla2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Nombre", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            OutlinedTextField(
                value = casilla1,
                onValueChange = { casilla1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Apellidos", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Espacio(16)

            OutlinedTextField(
                value = casilla2,
                onValueChange = { casilla2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Email", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OutlinedTextField(
                value = casilla1,
                onValueChange = { casilla1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Contraseña", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Espacio(16)

            Text(text = "Sexo", fontSize = 20.sp, color = Color.Black)
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = seleccionarSexo == "Hombre",
                    onClick = { seleccionarSexo = "Hombre" }
                )
                Text(text = "Hombre")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = seleccionarSexo == "Mujer",
                    onClick = { seleccionarSexo = "Mujer" }
                )
                Text(text = "Mujer")
            }

            Espacio(16)

            Text(text = "Hobbies", fontSize = 20.sp, color = Color.Black)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = deporteChecked,
                    onCheckedChange = { deporteChecked = it }
                )
                Text(text = "Deporte")
                Spacer(modifier = Modifier.width(16.dp))
                Checkbox(
                    checked = pinturaChecked,
                    onCheckedChange = { pinturaChecked = it }
                )
                Text(text = "Pintura")
                Spacer(modifier = Modifier.width(16.dp))
                Checkbox(
                    checked = otroChecked,
                    onCheckedChange = {
                        otroChecked = it
                        vistalibros = it
                    }
                )
                Text(text = "Otro")
            }

            Espacio(16)

            Button(
                onClick = {
                    vistalibros = !vistalibros
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Acceder")
            }

            if (vistalibros) {
                ListaLibro()
            }
        }
    }
}


@Composable
fun Espacio(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}
@Composable
fun ListaLibro() {
    val books = listOf(
        Book("Harrison's Principles of Internal Medicine", "Referencia estándar en medicina interna.", "17/08/2018"),
        Book("Gray's Anatomy", "Texto clásico de anatomía humana.", "20/09/2015"),
        Book("Robbins Basic Pathology", "Fundamentos de patología para estudiantes.", "11/05/2017"),
        Book("Guyton and Hall Textbook of Medical Physiology", "Libro completo sobre fisiología humana.", "03/06/2020"),
        Book("Goodman & Gilman's The Pharmacological Basis of Therapeutics", "Referencia en farmacología.", "22/12/2017"),
        Book("Nelson Textbook of Pediatrics", "Guía completa de pediatría.", "18/04/2019"),
        Book("Kaplan & Sadock's Synopsis of Psychiatry", "Compendio de psiquiatría clínica.", "09/10/2014"),
        Book("Williams Obstetrics", "Referencia en obstetricia.", "12/05/2018"),
        Book("Sabiston Textbook of Surgery", "Principios y práctica de cirugía.", "27/06/2016"),
        Book("Mandell, Douglas, and Bennett's Principles and Practice of Infectious Diseases", "Guía sobre enfermedades infecciosas.", "19/08/2019")
    )

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(books) { book ->
            Cartalibro(book)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun Cartalibro(book: Book) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = book.title,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = book.description)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Fecha de publicación: ${book.publishDate}",
                style = TextStyle(color = Color.Gray)
            )
        }
    }
}

data class Book(val title: String, val description: String, val publishDate: String)

