package com.bright.listofmessages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bright.listofmessages.ui.theme.ListOfProgramsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListOfProgramsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Conversation(
                        listOf(
                            Program("MS in Computer Science", "We’ve incorporated the leading personal development technique for maximizing success in our curriculum.  As a student, you’ll have the opportunity to learn the Transcendental Meditation® technique to improve your learning ability and job performance."),
                            Program("MA in Studio Art", "In our unique MA in Art, you’ll enjoy an intensive, two-semester exploration into studio practice while cultivating a deep connection to yourself through the Transcendental Meditation technique. In this creative environment, supported by expert faculty, peers, and prominent guest artists, you’ll create a sustainable studio practice — the best foundation for entering an MFA program or a career in art."),
                            Program("Low-Residency MFA in Visual Art", "The Low Residency MFA in Visual Art gives you the opportunity to pursue an in-depth graduate-level experience in art that is flexible and tailored to your individual needs. You also cultivate a community of support around your practice, developing friendships and connections to sustain your life in art."),
                            Program("David Lynch MFA in Screenwriting", "At the innovative David Lynch MFA in Screenwriting, you’ll have the opportunity to learn the Transcendental Meditation (TM) technique while acquiring the knowledge you need to become a professional screenwriter. The practice of TM will help you grow personally while you sharpen your writing skills and gain access to deeper levels of your creativity, discovering how — as David Lynch says — to catch the big fish."),
                            Program("MS in Maharishi AyurVeda & Integrative Medicine", "You’ll study the Maharishi AyurVedaSM health system, which addresses the body, mind, and environment of an individual to help them become holistically healthy."),
                            Program("MS in Aromatherapy & Ayurveda", "As a student in this program, you’ll gain a robust knowledge of the therapeutic properties and practical applications of essential oils."),
                            Program("PhD in Physiology & Health", "This PhD in Physiology & Health is a research program that is designed for graduate health professionals or those with a master’s in physiology, master of science in Maharishi AyurVeda and Integrative Medicine, or the equivalent, to conduct original research on the clinical effects and basic mechanisms of Maharishi AyurVeda, the Transcendental Meditation® technique, and other prevention-oriented, natural health care programs."),
                            Program("MA in Consciousness & Human Potential", "Ancient and modern teachers looked within themselves to find answers to questions like: “Who am I?” “Where am I going?” “How can I become more creative and develop my full potential?” “How am I connected to everything around me?” and “What is the nature of this reality in which we live?”"),
                            Program("MA in Enlightenment and Leadership", "You’ll dive into 12 fundamental areas of society, studying (a) their distinctive principles, (b) the deeper principles they all have in common, and (c) the deepest reality of all areas — the field of pure consciousness, pure intelligence, which is your own Self."),
                            Program("PhD in Maharishi Vedic Science", "Maharishi Vedic Science is the study of the unbounded, infinite field of consciousness lying at the basis of phenomenal existence and located within everyone as their own innermost Self. During the doctoral program, students will explore this field of intelligence both experientially – through daily practice of the Transcendental Meditation® technique and the TM-Sidhi® program – and by intellectual inquiry in classroom studies of the most advanced, most profound topics of Maharishi Vedic Science."),
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Conversation(programs: List<Program>) {
    LazyColumn {
        items(programs) {programs -> ProgramCard(programs)}
    }
}

@Composable
fun ProgramCard(program: Program) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp) // Add padding to each row
    ) {
        Image(
            painter = painterResource(id = R.drawable.course),
            contentScale = ContentScale.Inside,
            contentDescription = "course",
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .clip(CircleShape)
                .size(70.dp)
                .border(width = 2.dp, shape = CircleShape, color = Color.LightGray)
        )
        Spacer(modifier = Modifier.width(4.dp))
        //create a mutable state variable that trigger UI updates when its value changes
        var isExpanded by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier.clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = program.name,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = program.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = if(isExpanded) Int.MAX_VALUE else 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConversationPreview() {
    ListOfProgramsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Conversation(
                listOf(
                    Program("MS in Computer Science", "We’ve incorporated the leading personal development technique for maximizing success in our curriculum.  As a student, you’ll have the opportunity to learn the Transcendental Meditation® technique to improve your learning ability and job performance."),
                    Program("MA in Studio Art", "In our unique MA in Art, you’ll enjoy an intensive, two-semester exploration into studio practice while cultivating a deep connection to yourself through the Transcendental Meditation technique. In this creative environment, supported by expert faculty, peers, and prominent guest artists, you’ll create a sustainable studio practice — the best foundation for entering an MFA program or a career in art."),
                    Program("Low-Residency MFA in Visual Art", "The Low Residency MFA in Visual Art gives you the opportunity to pursue an in-depth graduate-level experience in art that is flexible and tailored to your individual needs. You also cultivate a community of support around your practice, developing friendships and connections to sustain your life in art."),
                )
            )
        }
    }
}

data class Program(
    val name: String,
    val description: String
)