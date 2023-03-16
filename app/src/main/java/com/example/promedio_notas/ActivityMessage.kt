package com.example.promedio_notas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityMessage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val findleMessage = findViewById<TextView>(R.id.txtMessage)

        var miBundle: Bundle? = this.intent.extras


        if(miBundle != null){
            findleMessage.text="Alumno: ${miBundle.getString("nombreAprendiz")} \nMateria: ${miBundle.getString("nombreMateria")} \nSus notas: \nNota 1:  ${miBundle.getDouble("nota1")} \nNota 2: ${miBundle.getDouble("nota2")} \nNota 3:  ${miBundle.getDouble("nota3")} \nPromedio: ${miBundle.getDouble("promedioNotas")} \nEl estado es: "

        }
        val estado=findViewById<TextView>(R.id.textView2)
        if(miBundle?.getDouble("promedioNotas")!! >=3.5){
            estado.text=" ${miBundle?.getString("mensaje")}"
            estado.setTextColor(Color.GREEN)
        }else{
            estado.text=" ${miBundle?.getString("mensaje")}"
            estado.setTextColor(Color.RED)

        }
        val btnExit:Button = findViewById(R.id.txtSalir)
        btnExit.setOnClickListener{onClick()}

    }

    private fun onClick() {
        finish()
    }
}
