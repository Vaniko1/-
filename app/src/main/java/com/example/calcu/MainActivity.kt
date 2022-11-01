package com.example.calcu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand = 0.0

    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {
            val text = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (text == "0") {
                text == ""
            }

            if (number == ".") {
                if (!("." in text)) {
                    val result = text + number
                    resultTextView.text = result
                }
            } else {
                val result = text + number
                resultTextView.text = result
            }

        }
    }

    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {
            operand = resultTextView.text.toString().toDouble()
            operation = clickedView.text.toString()

            resultTextView.text = ""
        }
    }

    fun equalsClick(clickedView: View) {
        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (secOperandText.isNotEmpty()) {
            secOperand = secOperandText.toString().toDouble()
        }


        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "x²" -> resultTextView.text = (operand * operand).toString()
            "√" -> resultTextView.text = (kotlin.math.sqrt(operand)).toString()
            "%" -> resultTextView.text = ((operand / 100) * secOperand).toString()
        }

    }

    fun deleteClick(clickedView: View) {
        val text = resultTextView.text.toString()
        if (text.isNotEmpty()) {
            resultTextView.text = text.dropLast(1)
        }

    }
}