package com.app.spritually.ui.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.abcmcoe.trackpad.helpers.ToastMessageHelper
import com.app.spritually.R
import com.app.spritually.adapter.HistoryListAdapter
import com.app.spritually.base.BaseActivity
import com.app.spritually.base.BaseFragment
import com.app.spritually.model.HistoryModel
import com.app.spritually.networking.WatsonNetworking
import com.app.spritually.viewmodel.HistoryViewModel
import androidx.lifecycle.Observer
import java.util.*
import kotlin.collections.ArrayList

// Kotlin Extension - Observe Data Once
fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>){
    observe(lifecycleOwner, object: Observer<T> {
      override fun onChanged(t: T){
          observer.onChanged(t)
          removeObserver(this)
      }
    })
}

class HistoryFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyText: TextView
    private var dummyList: List<HistoryModel> = ArrayList()

    private lateinit var historyViewModel : HistoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        historyViewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)

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

        // Get All Data from Observer
        historyViewModel.getAllData().observe(viewLifecycleOwner,
            Observer<List<HistoryModel>>{items ->
                adapter.setLists(items)

            })


        return view
    }

    private fun getAllData(){

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