package com.app.spritually.ui.fragments

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.app.spritually.R
import com.app.spritually.base.BaseFragment
import com.app.spritually.helper.ToastMessageHelper
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment: BaseFragment() {
    private lateinit var questionInputTextView: TextView
    private lateinit var answerOutputTextView: TextView
    private lateinit var speakButton: Button

    private lateinit var tts: TextToSpeech

    private var TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        tts = TextToSpeech(context) {
            if (it == TextToSpeech.SUCCESS) {
                val result = tts.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                    // Show Error
                    context?.let { it1 -> ToastMessageHelper.make(it1, "Language Not Supported") }
                }
            } else {
                context?.let { it1 -> ToastMessageHelper.make(it1, "Initilization Error") }
            }
        }

        questionInputTextView = view.findViewById(R.id.questionInputTextView)
        answerOutputTextView = view.findViewById(R.id.answerOutputTextView)
        speakButton = view.findViewById(R.id.speakButton)

        speakButton.setOnClickListener {
            //TODO: Toggle a way to speak to device
            startVoiceInput()
        }
        return view
    }

    // Start Text to Speech for Local Text to Speech
    private fun startVoiceInput() {
        val voiceIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        voiceIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        voiceIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak!")
        try {
            startActivityForResult(voiceIntent, 100)
        } catch (e: ActivityNotFoundException) {
            // Catch Other Errors
            Log.e(TAG, e.printStackTrace().toString())
        }
    }

    // Get result from voice Input and repeat it back
    // TODO: Use Networking for IBM Watson Assistant
    private fun resultOutput(output: String){
        tts.speak(output, TextToSpeech.QUEUE_FLUSH, null)
    }

    // Print Results from Recognizer Intent to Activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            100 -> { // Speech to Text Input: Question Input
                if (resultCode == RESULT_OK && null != data) {
                    val result: ArrayList<String> = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    questionInputTextView.text = result!![0]
                    resultOutput(result!![0])
                }
                
                else{ questionInputTextView.text = "An unknown error occured" }
            }

            101->{ // Text To Speech Output

            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {
        super.onPause()

        tts.stop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        super.onDestroy()

        tts.stop()
    }
}