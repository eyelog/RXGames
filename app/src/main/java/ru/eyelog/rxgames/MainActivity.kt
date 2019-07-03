package ru.eyelog.rxgames

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.eyelog.rxgames.module001single.Module001SingleActivity
import ru.eyelog.rxgames.module002.Module002Activity
import ru.eyelog.rxgames.module003.Module003Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt001Single.setOnClickListener {
            val intent = Intent(this, Module001SingleActivity::class.java)
            startActivity(intent)
        }

        bt002Stream.setOnClickListener {
            val intent = Intent(this, Module002Activity::class.java)
            startActivity(intent)
        }

        bt003FlatMap.setOnClickListener {
            val intent = Intent(this, Module003Activity::class.java)
            startActivity(intent)
        }
    }
}
