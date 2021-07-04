package project.paveltoy.kotlin_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import project.paveltoy.kotlin_lesson1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_execute).setOnClickListener{showFragment()}
    }

    private fun showFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_main, MainFragment())
                .commit()
    }
}