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
import kotlinx.android.synthetic.main.fragment_encuesta_actitud_del_docente.*

class ActitudDocenteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(
            R.layout.fragment_encuesta_actitud_del_docente,
            container,
            false
        )
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {
            val respuesta18 = respuesta18.checkedRadioButtonId
            val respuesta19 = respuesta19.checkedRadioButtonId
            val respuesta20 = respuesta20.checkedRadioButtonId
            val respuesta21 = respuesta21.checkedRadioButtonId

            when {
                respuesta18 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 18",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta19 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 19",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta20 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 20",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta21 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 21",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = ActitudEstudianteFragmen()
                    val respuestas = arguments
                    if (respuestas != null) {
                        respuestas.putInt("respuesta18", 1)
                        respuestas.putInt("respuesta19", 1)
                        respuestas.putInt("respuesta20", 1)
                        respuestas.putInt("respuesta21", 1)
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