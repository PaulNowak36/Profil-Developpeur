package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DeveloperScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// L'écran du profil développeur
@Composable
fun DeveloperScreen(modifier: Modifier = Modifier) {
    DeveloperFile(
        name = "Paul NOWAK",
        title = "Développeur C++",
        text = "Etudiant en première année de mastère spécialisé dans l'architecture des logiciels.",
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun DeveloperFile(
    name: String,
    title: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(color = Color.LightGray) {
        Column (
            modifier = modifier
        ) {
            DeveloperName(
                name = name,
                modifier = modifier.padding(12.dp)
            )
            DeveloperTitle(
                title = title,
                modifier = modifier.padding(12.dp)
            )
            DeveloperDescription(
                text = text,
                modifier = modifier.padding(12.dp)
            )
        }
    }
}

@Composable
fun DeveloperName(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        modifier = modifier,
        color = Color.Magenta
    )
}

@Composable
fun DeveloperTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        modifier = modifier
    )
}

@Composable
fun DeveloperDescription(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DeveloperScreenPreview() {
    ProfilDeveloppeurTheme {
        DeveloperScreen()
    }
}