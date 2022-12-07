package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unoBoton.setOnClickListener{numeroPresionado("1") }
        dos.setOnClickListener{numeroPresionado("2") }
        tres.setOnClickListener{numeroPresionado("3") }
        cuatro.setOnClickListener{numeroPresionado("4") }
        cinco.setOnClickListener{numeroPresionado("5") }
        seis.setOnClickListener{numeroPresionado("6") }
        siete.setOnClickListener{numeroPresionado("7") }
        ocho.setOnClickListener{numeroPresionado("8") }
        nueve.setOnClickListener{numeroPresionado("9") }
        cero.setOnClickListener{numeroPresionado("0") }
        puntoBoton.setOnClickListener{numeroPresionado(".")}


        sumaBoton.setOnClickListener{operacionPresionada(suma)}
        restaBoton.setOnClickListener{operacionPresionada(resta)}
        porBoton.setOnClickListener{operacionPresionada(multiplicacion)}
        dividirBoton.setOnClickListener{operacionPresionada(division)}

        eliminarBoton.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultadoTextView.text = ""
            operacion = NO_OPERACION
        }

        igualBoton.setOnClickListener{
            var resultado = when(operacion){
                suma -> num1 + num2
                resta -> num1 - num2
                multiplicacion -> num1 * num2
                division -> num1 / num2
                else -> 0

            }

            resultadoTextView.text = if("$resultado".endsWith(".0")) { "$resultado".replace(".0","") } else { "%.2f".format(resultado) }
        }

    }

    private fun numeroPresionado (digito: String){
        resultadoTextView.text = "${resultadoTextView.text}$digito"

        if(operacion == NO_OPERACION){
            num1 = resultadoTextView.text.toString().toDouble()

        }else{
            num2 = resultadoTextView.text.toString().toDouble()

        }
    }

    private fun operacionPresionada (operacion: Int){
        this.operacion = operacion


        resultadoTextView.text = ""

    }

    companion object{
        const val suma = 1
        const val resta = 2
        const val multiplicacion = 3
        const val division = 4
        const val NO_OPERACION = 0
    }


}