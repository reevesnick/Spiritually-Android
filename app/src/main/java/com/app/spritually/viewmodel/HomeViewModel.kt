package com.app.spritually.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.ibm.watson.assistant.v2.Assistant
import com.ibm.watson.text_to_speech.v1.TextToSpeech


class HomeViewModel(application: Application): AndroidViewModel(application) {

    lateinit var assistant: Assistant
    lateinit var textToSpeech: TextToSpeech
    init{

    }

    fun startTTS(){

    }

    fun IBMWatsonServices(){

    }

}