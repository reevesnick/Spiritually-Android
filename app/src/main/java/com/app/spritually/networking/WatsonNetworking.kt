package com.app.spritually.networking

import android.content.Context
import android.util.Log
import com.app.spritually.R
import com.ibm.cloud.sdk.core.http.Response
import com.ibm.cloud.sdk.core.http.ServiceCall
import com.ibm.cloud.sdk.core.security.IamAuthenticator
import com.ibm.watson.assistant.v2.Assistant
import com.ibm.watson.assistant.v2.model.*
import com.ibm.watson.speech_to_text.v1.SpeechToText
import kotlinx.android.synthetic.main.fragment_home.view.*

class WatsonNetworking {

    // IBM Fields
    private lateinit var ibmTts: com.ibm.watson.text_to_speech.v1.TextToSpeech
    private lateinit var ibmSst: SpeechToText
    private lateinit var ibmAssistant: Assistant
    private lateinit var watsonAssistantSession: Response<SessionResponse>


    fun exectueService(input: String, context: Context){
        kotlin.run {
            startIbmServices(context)
            try {
                if (watsonAssistantSession == null) {
                    var call: ServiceCall<SessionResponse> = ibmAssistant.createSession(
                        CreateSessionOptions.Builder()
                            .assistantId(context.getString(R.string.assistant_id))
                            .build()
                    )
                    watsonAssistantSession = call.execute()
                }

                var messageInput = MessageInput.Builder().text(input).build()
                var messageOptions = MessageOptions.Builder()
                    .assistantId(context.getString(R.string.assistant_id))
                    .input(messageInput)
                    .sessionId(watsonAssistantSession.result.sessionId)
                    .build()

                var response: Response<MessageResponse> = ibmAssistant.message(messageOptions).execute()
                Log.i("Response:","${response.result}")


           } catch (e: Exception){
                e.printStackTrace()
           }
        }
    }

    private fun startIbmServices(context: Context){
        ibmAssistant = Assistant(
            "10-11-2020",
            IamAuthenticator(context.getString(R.string.assistant_apikey))
        )
        ibmAssistant.serviceUrl = context.getString(R.string.assistant_url)

        ibmSst = SpeechToText(IamAuthenticator(context.getString(R.string.STT_apikey)))
        ibmSst.serviceUrl = context.getString(R.string.STT_url)

        ibmTts = com.ibm.watson.text_to_speech.v1.TextToSpeech(
            IamAuthenticator(
                context.getString(
                    R.string.TTS_apikey
                )
            )
        )
        ibmTts.serviceUrl = context.getString(R.string.TTS_url)
    }
}