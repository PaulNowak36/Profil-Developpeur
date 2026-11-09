package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            DeveloperHeading(
                name = name,
                title = title,
                modifier = modifier.fillMaxWidth()
            )
            DeveloperDescription(
                text = text,
                fontSize = 20,
                modifier = modifier.fillMaxWidth().padding(12.dp)
            )
            DeveloperSkills(
                fontSize = 20,
                modifier = modifier.fillMaxWidth().padding(12.dp)
            )
        }
    }
}

@Composable
fun DeveloperHeading(
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Surface(color = Color.Blue) {
        Column {
            DeveloperName(
                name = name,
                fontSize = 35,
                modifier = modifier
            )
            DeveloperTitle(
                title = title,
                fontSize = 25,
                modifier = modifier
            )
        }
    }
}

@Composable
fun DeveloperName(
    name: String,
    fontSize: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        fontSize = fontSize.sp,
        modifier = modifier,
        color = Color.Yellow
    )
}

@Composable
fun DeveloperTitle(
    title: String,
    fontSize: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        fontSize = fontSize.sp,
        modifier = modifier,
        color = Color.Green
    )
}

@Composable
fun DeveloperDescription(
    text: String,
    fontSize: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        modifier = modifier
    )
}

@Composable
fun DeveloperSkills(
    fontSize: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Liste des compétences: ",
        fontWeight = FontWeight.Bold,
        fontSize = fontSize.sp,
        modifier = modifier
    )
    DeveloperUniqueSkill(
        skill = "C++",
        fontSize = fontSize,
        modifier = modifier
    )
    DeveloperUniqueSkill(
        skill = "Python",
        fontSize = fontSize,
        modifier = modifier
    )
    DeveloperUniqueSkill(
        skill = "TypeScript",
        fontSize = fontSize,
        modifier = modifier
    )

}

@Composable
fun DeveloperUniqueSkill(
    skill : String,
    fontSize: Int,
    modifier: Modifier = Modifier
) {

    Text(
        text = "- $skill",
        fontSize = fontSize.sp,
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