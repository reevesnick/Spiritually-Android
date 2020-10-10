package com.app.spritually.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.spritually.R
import com.app.spritually.base.BaseActivity
import com.app.spritually.base.BaseFragment
import com.app.spritually.ui.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Start the Home Tab when App is launched
        val fragTransaction = supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment())
        fragTransaction.addToBackStack(null)
        fragTransaction.commit()

        // Listener to select different tabs to go to different Fragments
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home_tab ->{
                    val fragTransaction = supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment())
                    fragTransaction.addToBackStack(null)
                    fragTransaction.commit()
                    true
                }

                R.id.profile_tab ->{
                    true
                }

                R.id.history_tab ->{
                    true
                }
                else -> false
            }

        }
    }


}