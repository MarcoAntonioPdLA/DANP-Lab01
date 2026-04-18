package com.unsa.danp_lab01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unsa.danp_lab01.ui.theme.DANPLab01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DANPLab01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FirstScreen(
                        title = "Primera aplicación",
                        subtitle = "Esta es una interfaz básica.",
                        buttonText = "Botón simple",
                        modifier = Modifier.padding(innerPadding)
                    )
                    TasksList()
                }
            }
        }
    }
}

@Composable
fun FirstScreen(title: String, subtitle: String, buttonText: String, modifier: Modifier = Modifier) {
    var buttonMessage by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = subtitle,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                buttonMessage = "¡Botón presionado!"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = buttonText)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = buttonMessage,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(name = "First Screen Preview", showBackground = true)
@Composable
fun FirstScreenPreview() {
    DANPLab01Theme {
        FirstScreen(
            title = "Primera aplicación",
            subtitle = "Esta es una interfaz básica.",
            buttonText = "Botón simple"
        )
    }
}

data class Task(
    val title: String,
    val description: String
)

@Composable
fun TasksList() {
    val tasks = List(size = 10) { index ->
        Task(
            title = "Tarea ${index + 1}",
            description = "Descripción de la tarea ${index + 1}"
        )
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Lista de tareas:",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(tasks) { task ->
                TaskItem(task = task)
            }
        }
    }
}

@Composable
fun TaskItem(task: Task) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Text(
            text = task.title,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = task.description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(name = "ListPreview", showBackground = true)
@Composable
fun ListPreview() {
    DANPLab01Theme {
        TasksList()
    }
}