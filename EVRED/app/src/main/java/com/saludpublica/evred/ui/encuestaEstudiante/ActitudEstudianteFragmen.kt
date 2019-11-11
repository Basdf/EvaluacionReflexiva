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
import kotlinx.android.synthetic.main.fragment_encuesta_actitud_del_estudiante.*

class ActitudEstudianteFragmen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(
            R.layout.fragment_encuesta_actitud_del_estudiante,
            container,
            false
        )
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {
            val respuesta22 = respuesta22.checkedRadioButtonId
            val respuesta23 = respuesta23.checkedRadioButtonId
            val respuesta24 = respuesta24.checkedRadioButtonId
            val respuesta25 = respuesta25.checkedRadioButtonId
            val respuesta26 = respuesta26.checkedRadioButtonId
            val respuesta27 = respuesta27.checkedRadioButtonId
            val respuesta28 = respuesta28.checkedRadioButtonId

            when {
                respuesta22 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 22",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta23 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 23",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta24 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 24",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta25 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 25",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta26 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 26",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta27 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 27",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta28 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 28",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = ObservacionesFragment()
                    val respuestas = arguments
                    if (respuestas != null) {
                        respuestas.putInt("respuesta22", 1)
                        respuestas.putInt("respuesta23", 1)
                        respuestas.putInt("respuesta24", 1)
                        respuestas.putInt("respuesta25", 1)
                        respuestas.putInt("respuesta26", 1)
                        respuestas.putInt("respuesta27", 1)
                        respuestas.putString("respuesta28", "si")
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