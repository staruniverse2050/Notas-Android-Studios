package com.example.promedio_notas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.truncate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton:Button = findViewById(R.id.buttonCalcular)
        myButton.setOnClickListener{onClick()}

    }

    private fun onClick() {
        val fieldNote1: EditText = findViewById(R.id.txtNota1)
        val fieldNote2: EditText = findViewById(R.id.txtNota2)
        val fieldNote3: EditText = findViewById(R.id.txtNota3)
        val txtResults: TextView = findViewById(R.id.txtResult)

        val note1:Double = fieldNote1.text.toString().toDouble()
        val note2:Double = fieldNote2.text.toString().toDouble()
        val note3:Double = fieldNote3.text.toString().toDouble()

        val average:Double = truncate((note1 + note2 + note3) / 3)
        val intent = Intent(this, ActivityMessage::class.java)
        val bundle: Bundle = Bundle()
        bundle.putDouble("promedioNotas", average)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
