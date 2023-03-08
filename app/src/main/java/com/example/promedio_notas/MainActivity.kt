package com.example.promedio_notas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var fieldName: EditText? = null
    var fieldSubject: EditText? = null
    var fieldNote1: EditText? = null
    var fieldNote2: EditText? = null
    var fieldNote3: EditText? = null
    var txtResults: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fieldName = findViewById(R.id.txtName)
        fieldSubject = findViewById(R.id.txtSubject)
        fieldNote1 = findViewById(R.id.txtNota1)
        fieldNote2 = findViewById(R.id.txtNota2)
        fieldNote3 = findViewById(R.id.txtNota3)
        txtResults = findViewById(R.id.txtResult)


        val myButton:Button = findViewById(R.id.buttonCalcular)
        myButton.setOnClickListener{onClick()}
    }

    private fun onClick() {
                val intent = Intent(this, ActivityMessage::class.java)
                val miBundle:Bundle = Bundle()
                miBundle.putString("Nombre", fieldName!!.text.toString())
                intent.putExtras(miBundle)
                startActivity(intent)



    }
}