package project.paveltoy.kotlin_lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.lang.NumberFormatException
import kotlin.random.Random

class SecondFragment : Fragment() {
    private lateinit var tvResult: TextView
    private lateinit var tvRemark: TextView
    private lateinit var etNumber: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        etNumber = view.findViewById(R.id.et_number)
        tvResult = view.findViewById(R.id.tv_fragment2_result)
        tvRemark = view.findViewById(R.id.tv_fragment2_remark)
        view.findViewById<Button>(R.id.button_fragment2_execute).setOnClickListener{performAction(view)}
    }

    private fun performAction(view: View) {
        tvRemark.text = ""
        val number = getNumber()
        if (number == 0) return
        when (view.findViewById<RadioGroup>(R.id.radio_group_variants).checkedRadioButtonId) {
            R.id.rb_sum_members -> sumMembers(number)
            R.id.rb_factorial -> factorial(number)
            R.id.rb_random -> getRandom(number)
        }
    }

    private fun getNumber(): Int {
        return try {
            etNumber.text.toString().toInt()
        } catch (e: NumberFormatException) {
            0
        }
    }

    private fun sumMembers(number: Int) {
        var sum = 0
        for (item: Int in 1..number) {
            sum += item
        }
        tvResult.text = sum.toString()
    }

    private fun factorial(number: Int) {
        var num = number
        if (number > 25) {
            num = 25
            etNumber.setText(num.toString())
        }
        var result: Long = 1
        for (item: Int in 1..num) {
            result *= item
        }
        tvResult.text = result.toString()
        tvRemark.text = resources.getString(R.string.factorial_remark)
    }

    private fun getRandom(number: Int) {
        tvResult.text = Random.nextInt(1, number).toString()
    }
}