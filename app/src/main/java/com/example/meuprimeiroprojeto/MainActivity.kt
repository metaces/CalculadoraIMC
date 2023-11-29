package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val editWeight: EditText = findViewById(R.id.editWeight)
        val editHeight: EditText = findViewById(R.id.editHeight)

        buttonCalculate.setOnClickListener {

            val heightStr = editHeight.text.toString()
            val weightStr = editWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {

                val heightPerson: Float = heightStr.toFloat()
                val weightPerson: Float = weightStr.toFloat()
                val imcResult: Float = weightPerson/(heightPerson*heightPerson)


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", imcResult)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fields empty", Toast.LENGTH_LONG).show()
            }

        }
    }
}