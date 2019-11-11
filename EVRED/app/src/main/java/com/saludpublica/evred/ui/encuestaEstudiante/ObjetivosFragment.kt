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
import kotlinx.android.synthetic.main.fragment_encuesta_objetivos_y_contenidos.*

class ObjetivosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(
            R.layout.fragment_encuesta_objetivos_y_contenidos,
            container,
            false
        )
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {


            val respuesta4 = respuesta4.checkedRadioButtonId
            val respuesta5 = respuesta5.checkedRadioButtonId
            val respuesta6 = respuesta6.checkedRadioButtonId
            when {
                respuesta4 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 4",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta5 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 5",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta6 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 6",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {


                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = AspectosMetodologicosFragment()
                    val respuestas = arguments
                    if (respuestas != null) {
                        respuestas.putInt("respuesta4", 1)//poner hay la respuesta de la pregunta
                        respuestas.putInt("respuesta5", 1)
                        respuestas.putInt("respuesta6", 1)
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