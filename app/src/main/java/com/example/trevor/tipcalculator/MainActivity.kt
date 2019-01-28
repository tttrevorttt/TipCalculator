package com.example.trevor.tipcalculator

import android.icu.text.NumberFormat
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener {
    private val currencyFormat = NumberFormat.getCurrencyInstance()
    private var tipPercent = 7.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calcTipButton = findViewById<Button>(R.id.calculate_tip_button)
        val resultText = findViewById<TextView>(R.id.txt_total_amt)
        val spinner: Spinner = findViewById(R.id.spinnerTip)

        val edtCheckAmount: EditText = findViewById(R.id.checktotal)
        val txtTipAmount: TextView = findViewById(R.id.txt_Tip_Amount)

        spinner.onItemSelectedListener = this
        Log.d("GETS TO HERE","Gets to here")


        calcTipButton.setOnClickListener {
            if (edtCheckAmount.text.toString().trim().isNotEmpty()) {
                //removes keyboard from screen
                edtCheckAmount.onEditorAction(EditorInfo.IME_ACTION_DONE)



                var chkAmount = checktotal.text.toString().toDouble()
                var tipAmount = chkAmount * tipPercent
                var totalAmount = chkAmount + tipAmount

                resultText.setText(currencyFormat.format(totalAmount).toString())
                txtTipAmount.setText(currencyFormat.format(tipAmount).toString())


            }

        }

    }
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p2)
        {
            0 -> tipPercent = .0
            1 -> tipPercent = .1
            2 -> tipPercent = .15
            3 -> tipPercent = .2
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.wtf("WhassupthisisanERROR", "Put your hands in the ERROR")
    }



}





