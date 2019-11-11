package com.saludpublica.evred.ui.encuestaEstudiante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.saludpublica.evred.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_encuesta_evaluacion.*


class EvaluacionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(
            R.layout.fragment_encuesta_evaluacion,
            container,
            false
        )
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {

            val respuesta12 = respuesta12.checkedRadioButtonId
            val respuesta13 = respuesta13.checkedRadioButtonId
            val respuesta14 = respuesta14.checkedRadioButtonId
            val respuesta15 = respuesta15.checkedRadioButtonId
            val respuesta16 = respuesta16.checkedRadioButtonId
            val respuesta17 = respuesta17.checkedRadioButtonId

            when {
                respuesta12 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 12",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta13 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 13",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta14 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 14",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta15 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 15",
                    Toast.LENGTH_LONG
                ).show()
                respuesta16 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 16",
                    Toast.LENGTH_LONG
                ).show()
                respuesta17 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 17",
                    Toast.LENGTH_LONG
                ).show()

                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = ActitudDocenteFragment()
                    val respuestas = arguments
                    if (respuestas != null) {
                        respuestas.putInt("respuesta12", 1)//poner hay la respuesta de la pregunta
                        respuestas.putInt("respuesta13", 1)
                        respuestas.putInt("respuesta14", 1)
                        respuestas.putInt("respuesta15", 1)
                        respuestas.putInt("respuesta16", 1)
                        respuestas.putInt("respuesta17", 1)

                    }
                    fragment.arguments = respuestas
                    fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                    fragmentTransaction?.commit()
                }
            }
        }
        return root
    }
}