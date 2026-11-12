package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        skillsList = arrayOf("C#", "Python", "React"),
        mail = "p.nowak@myskolae.fr",
        isShown = true,
        onSkillsClick = {
            // Plus tard : Montrer les compétences
        },
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun DeveloperFile(
    name: String,
    title: String,
    text: String,
    mail: String,
    skillsList: Array<String>,
    isShown: Boolean,
    onSkillsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(color = Color.White) {
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
                modifier = modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            DeveloperSkillsSection(
                fontSize = 20,
                skillsList = skillsList,
                isShown = isShown,
                onSkillsClick = onSkillsClick,
                modifier = modifier
            )
            DeveloperMail(
                mail = mail,
                fontSize = 20,
                modifier = modifier
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
    Surface(color = Color.LightGray) {
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
        color = Color.Red
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
        fontWeight = FontWeight.Bold,
        modifier = modifier
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
fun DeveloperSkillsSection(
    fontSize: Int,
    skillsList: Array<String>,
    isShown: Boolean,
    onSkillsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {

        Row (
            modifier = modifier,
        ){
            Text(
                text = "Liste des compétences: ",
                fontWeight = FontWeight.Bold,
                fontSize = fontSize.sp,
                modifier = modifier.weight(1f)
            )

            ShowSkillsButton(
                isShown = isShown,
                fontSize = fontSize,
                onSkillsClick = onSkillsClick,
                modifier = modifier
            )
        }
        if (isShown) {
            DeveloperSkillsList(
                fontSize = fontSize,
                skillsList = skillsList
            )
        }


    }

}

@Composable
fun DeveloperSkillsList(
    fontSize: Int,
    skillsList: Array<String>,
    modifier: Modifier = Modifier
) {

    Column {
        DeveloperUniqueSkill(
            skill = skillsList[0],
            fontSize = fontSize,
            modifier = modifier
        )
        DeveloperUniqueSkill(
            skill = skillsList[1],
            fontSize = fontSize,
            modifier = modifier
        )
        DeveloperUniqueSkill(
            skill = skillsList[2],
            fontSize = fontSize,
            modifier = modifier
        )
    }
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

@Composable
fun ShowSkillsButton(
    isShown: Boolean,
    fontSize: Int,
    onSkillsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onSkillsClick,
        modifier = modifier
    ) {
        Text(
            text = if (isShown) {
                "Cacher"
            } else {
                "Montrer"
            },
            fontSize = fontSize.sp
        )
    }
}

@Composable
fun DeveloperMail(
    mail : String,
    fontSize: Int,
    modifier: Modifier = Modifier
) {

    Text(
        text = "Mon mail:  $mail",
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

@Preview(showBackground = true)
@Composable
fun ProductSkillsShownPreview() {
    ProfilDeveloppeurTheme {
        DeveloperFile(
            name = "Paul NOWAK",
            title = "Concepteur Développeur",
            text = "Etudiant en première année de mastère spécialisé dans l'architecture des logiciels.",
            skillsList = arrayOf("C++", "Python", "TypeScript"),
            mail = "p.nowak@myskolae.fr",
            isShown = true,
            onSkillsClick = {
                // Plus tard : Montrer les compétences
            },
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSkillsHiddenPreview() {
    ProfilDeveloppeurTheme {
        DeveloperFile(
            name = "Paul NOWAK",
            title = "Développeur Full Stack",
            text = "Etudiant en première année de mastère spécialisé dans l'architecture des logiciels.",
            skillsList = arrayOf("C++", "React", "HTML"),
            mail = "p.nowak@myskolae.fr",
            isShown = false,
            onSkillsClick = {
                // Plus tard : Montrer les compétences
            },
            modifier = Modifier
                .padding(16.dp)
        )
    }
}