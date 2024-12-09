package com.ucb.eldroid.removalproject.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ucb.eldroid.removalproject.R
import com.ucb.eldroid.removalproject.views.fragments.MenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MenuFragment())
                .commit()
        }
    }
}