package com.example.promedio_notas

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
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
        val name: EditText = findViewById(R.id.txtNombre)
        val subject: EditText = findViewById(R.id.txtSubject)

        val note1:Double = fieldNote1.text.toString().toDouble()
        val note2:Double = fieldNote2.text.toString().toDouble()
        val note3:Double = fieldNote3.text.toString().toDouble()
        val nameAprendiz:String = name.text.toString()
        val subjectAprendiz:String = subject.text.toString()

        val average: Double = (note1 + note2 + note3) / 3
        val formattedAverage = String.format("%.2f", average)

        var messageNote: String? = null

        if (average >= 3.5) {
            messageNote = "Aprobado"
        } else {
            messageNote = "Reprobado"
        }

        val intent = Intent(this, ActivityMessage::class.java)
        val content: Bundle = Bundle()
        content.putString("nombreAprendiz", subjectAprendiz)
        content.putString("nombreMateria", nameAprendiz)
        content.putString("promedioNotas", formattedAverage)
        content.putDouble("nota1", note1)
        content.putDouble("nota2", note2)
        content.putDouble("nota3", note3)
        content.putString("mensaje",messageNote)

        intent.putExtras(content)
        startActivity(intent)
    }
}
