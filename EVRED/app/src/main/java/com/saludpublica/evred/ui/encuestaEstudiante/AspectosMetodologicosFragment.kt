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

import kotlinx.android.synthetic.main.fragment_encuesta_aspectos_metodologicos.*

class AspectosMetodologicosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(
            R.layout.fragment_encuesta_aspectos_metodologicos,
            container,
            false
        )
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener {

            val respuestaItem1 = respuestaItem1.checkedRadioButtonId
            val respuestaItem2 = respuestaItem2.checkedRadioButtonId
            val respuestaItem3 = respuestaItem3.checkedRadioButtonId
            val respuestaItem4 = respuestaItem4.checkedRadioButtonId
            val respuestaItem5 = respuestaItem5.checkedRadioButtonId
            val respuestaItem6 = respuestaItem6.checkedRadioButtonId
            val respuestaItem7 = respuestaItem7.checkedRadioButtonId
            val respuesta8 = respuesta8.checkedRadioButtonId
            val respuesta9 = respuesta9.checkedRadioButtonId
            val respuesta10 = respuesta10.checkedRadioButtonId
            val respuesta11 = respuesta11.checkedRadioButtonId
            when {
                respuestaItem1 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder el item 1",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem2 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder el item 2",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem3 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder el item 3",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem4 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder el item 4",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem5 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder el item 5",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem6 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder el item 6",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem7 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder el item 7",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta8 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 8",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta9 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 9",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta10 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 10",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta11 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 11",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = EvaluacionFragment()
                    val respuestas = arguments
                    if (respuestas != null) {
                        respuestas.putInt("item1", 1)//poner hay la respuesta de la pregunta
                        respuestas.putInt("item2", 1)
                        respuestas.putInt("item3", 1)
                        respuestas.putInt("item4", 1)
                        respuestas.putInt("item5", 1)
                        respuestas.putInt("item6", 1)
                        respuestas.putInt("item7", 1)
                        respuestas.putInt("item8", 1)
                        respuestas.putInt("respuesta8", 1)
                        respuestas.putInt("respuesta9", 1)
                        respuestas.putInt("respuesta10", 1)
                        respuestas.putInt("respuesta11", 1)
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