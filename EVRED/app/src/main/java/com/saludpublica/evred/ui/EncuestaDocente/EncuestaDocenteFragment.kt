package com.saludpublica.evred.ui.EncuestaDocente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
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
                    respuesta.visibility = View.GONE
                }

            }

            //guardar en EncuestaDocente las respuestas de la pregunta
            var radioButtonId = respuesta.checkedRadioButtonId
            if (radioButtonId != -1) {
                var radioButtonView: View = respuesta.findViewById(radioButtonId)
                var indice: Int = respuesta.indexOfChild(radioButtonView)
                var radioButton: RadioButton = respuesta.getChildAt(indice) as RadioButton
                respuesta.clearCheck()
                //recojer los valores a guardar
                //radioButton.text

            }

            //argumento.text.toString()
            argumento.text.clear()
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
                    respuesta.visibility = View.VISIBLE
                }
            }
            //recargar los valores correspondientes
        }

        return root
    }


}