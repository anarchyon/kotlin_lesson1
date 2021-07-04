package project.paveltoy.kotlin_lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    private lateinit var tvResult: TextView
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etNumber1 = view.findViewById(R.id.et_number1)
        etNumber2 = view.findViewById(R.id.et_number2)

        view.findViewById<Button>(R.id.sum).setOnClickListener{sum()}
        view.findViewById<Button>(R.id.sub).setOnClickListener{sub()}
        view.findViewById<Button>(R.id.mult).setOnClickListener{mult()}
        view.findViewById<Button>(R.id.div).setOnClickListener{div()}

        tvResult = view.findViewById(R.id.tv_result)
    }

    private fun div() {
        val number1 = getNumber1()
        val number2 = getNumber2()
        tvResult.text = (number1 / number2).toString()
    }

    private fun getNumber2(): Double {
        return try {
            etNumber2.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }

    private fun getNumber1(): Double {
        return try {
            etNumber1.text.toString().toDouble()
        } catch(e: NumberFormatException) {
            0.0
        }
    }

    private fun mult() {
        val number1 = getNumber1()
        val number2 = getNumber2()
        tvResult.text = (number1 * number2).toString()
    }

    private fun sub() {
        val number1 = getNumber1()
        val number2 = getNumber2()
        tvResult.text = (number1 - number2).toString()
    }

    private fun sum() {
        val number1 = getNumber1()
        val number2 = getNumber2()
        tvResult.text = (number1 + number2).toString()
    }
}