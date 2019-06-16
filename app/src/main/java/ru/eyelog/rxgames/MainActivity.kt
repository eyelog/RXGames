package ru.eyelog.rxgames

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.eyelog.rxgames.module001.Module001Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt001.setOnClickListener {
            val intent = Intent(this, Module001Activity::class.java)
            startActivity(intent)
        }
    }
}
