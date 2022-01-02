package com.example.calculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }

        button_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }

        button_zero.setOnClickListener {
            input.text = addToInputText("0")
        }

        button_one.setOnClickListener {
            input.text = addToInputText("1")
        }

        button_two.setOnClickListener {
            input.text = addToInputText("2")
        }

        button_three.setOnClickListener {
            input.text = addToInputText("3")
        }

        button_four.setOnClickListener {
            input.text = addToInputText("4")
        }
        button_five.setOnClickListener {
            input.text = addToInputText("5")
        }
        button_six.setOnClickListener {
            input.text = addToInputText("6")
        }
        button_eight.setOnClickListener {
            input.text = addToInputText("7")
        }
        button_nine.setOnClickListener {
            input.text = addToInputText("8")
        }
        button_nine.setOnClickListener {
            input.text = addToInputText("9")
        }
        button_dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        button_division.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }
        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }

        button_equals.setOnClickListener {
            showResult()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun addToInputText(s: String): CharSequence? {
        return "${input.text}$s"
    }

}