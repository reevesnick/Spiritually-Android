package com.app.spritually.ui.fragments

import android.os.Bundle
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.spritually.R
import com.app.spritually.ui.theme.SprituallyTheme

class HomeCompose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePreview()
        }
    }
}


@Composable
fun QuestionSection(inputQuestion: String){
    Column() {
        Text(text = "Question", color = Color.White)
        Text("$inputQuestion", color = Color.White)
    }
}

@Composable
fun AnswerSection(outputAnswer: String){
    Column() {
        Text(text = "Answer" ,color = Color.White)
        Text("$outputAnswer", color = Color.White)
    }
}

@Composable
fun BottomFunction(){
    Row() {
        FloatingActionButton(onClick = {}){
            Text(text = "Speak")
        }
    }
}



@Preview(showBackground = true, showSystemUi = false, backgroundColor = 0xFF00BCD4)
@Composable
fun HomePreview() {
    Column (Modifier.padding(16.dp)){
        QuestionSection(inputQuestion = "What is the meaning of life?")
        Spacer(modifier = Modifier.height(25.dp))
        AnswerSection(outputAnswer = "The Answer is 42")
        Spacer(modifier = Modifier.height(25.dp))
        BottomFunction()
    }
}

