package com.saludpublica.evred.ui.encuestaDocente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.saludpublica.evred.R
import kotlinx.android.synthetic.main.fragment_encuesta_docente.*

class EncuestaDocenteFragment : Fragment() {
    private var numeroPregunta: Int = 1
    private lateinit var encuestaDocente: EncuestaDocenteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_encuesta_docente, container, false)
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {

            //guardar en EncuestaDocente las respuestas de la pregunta
            val radioButtonId1 = respuesta_1.checkedRadioButtonId
            val radioButtonId2 = respuesta_2.checkedRadioButtonId
            if (radioButtonId1 != -1 && radioButtonId2 != -1) {
                val radioButtonView1: View = respuesta_1.findViewById(radioButtonId1)
                val indice1: Int = respuesta_1.indexOfChild(radioButtonView1)
                val radioButtonView2: View = respuesta_1.findViewById(radioButtonId2)
                val indice2: Int = respuesta_1.indexOfChild(radioButtonView2)

                var radioButton1: RadioButton = respuesta_1.getChildAt(indice1) as RadioButton
                respuesta_1.clearCheck()
                respuesta_2.clearCheck()
                //recojer los valores a guardar
                //radioButton.text

            }

            //argumento.text.toString()
            argumento.text.clear()

            if (numeroPregunta < 6) {
                numeroPregunta++
            }
            when (numeroPregunta) {
                2 -> {
                    pregunta.text = getString(R.string.PreguntaD2)
                    atras.visibility = View.VISIBLE
                }
                3 -> pregunta.text = getString(R.string.PreguntaD3)
                4 -> pregunta.text = getString(R.string.PreguntaD4)
                5 -> pregunta.text = getString(R.string.PreguntaD5)
                6 -> {
                    pregunta.text = getString(R.string.observaciones)
                    siguiente.text = "Terminar"
                    respuesta_1.visibility = View.GONE
                }

            }

        }
        val atras: Button = root.findViewById(R.id.atras)
        atras.setOnClickListener() {
            numeroPregunta--
            when (numeroPregunta) {
                1 -> {
                    pregunta.text = getString(R.string.PreguntaD1)
                    atras.visibility = View.INVISIBLE
                }
                2 -> pregunta.text = getString(R.string.PreguntaD2)
                3 -> pregunta.text = getString(R.string.PreguntaD3)
                4 -> pregunta.text = getString(R.string.PreguntaD4)
                5 -> {
                    pregunta.text = getString(R.string.PreguntaD5)
                    siguiente.text = "Siguiente"
                    respuesta_1.visibility = View.VISIBLE
                }
            }
            //recargar los valores correspondientes
        }

        return root
    }


}