package com.example.promedio_notas

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
            findleMessage.text="El alumno sus nota fueron y el promedio fue de ${miBundle.getDouble("promedioNotas")}"
        }
        val btnExit:Button = findViewById(R.id.txtSalir)
        btnExit.setOnClickListener{onClick()}

    }

    private fun onClick() {
        finish()
    }
}
