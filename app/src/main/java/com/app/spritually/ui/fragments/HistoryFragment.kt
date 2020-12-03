package com.app.spritually.ui.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import com.abcmcoe.trackpad.helpers.ToastMessageHelper
import com.app.spritually.R
import com.app.spritually.adapter.HistoryListAdapter
import com.app.spritually.base.BaseActivity
import com.app.spritually.base.BaseFragment
import com.app.spritually.model.HistoryModel
import com.app.spritually.networking.WatsonNetworking
import java.util.*
import kotlin.collections.ArrayList

class HistoryFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyText: TextView
    private var dummyList: List<HistoryModel> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        recyclerView = view.findViewById(R.id.rv_history)
        emptyText = view.findViewById(R.id.empty_view)

        if (dummyList.isEmpty()){
            recyclerView.visibility = View.INVISIBLE
            emptyText.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyText.visibility = View.INVISIBLE
        }

        val adapter = HistoryListAdapter()

        recyclerView.adapter = adapter


        return view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {
        super.onStart()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {
        super.onPause()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        super.onDestroy()

    }
}