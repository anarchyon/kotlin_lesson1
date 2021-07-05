package project.paveltoy.kotlin_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_execute).setOnClickListener { showFragment() }
    }

    private fun showFragment() {
        when (defineFragmentId()) {
            0 -> showSelectedFragment(MainFragment())
            1 -> showSelectedFragment(SecondFragment())
        }
    }

    private fun defineFragmentId(): Int {
        return findViewById<Spinner>(R.id.spinner).selectedItemPosition
    }

    private fun showSelectedFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_main, fragment)
                .commit()

    }
}