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
import kotlinx.android.synthetic.main.fragment_encuesta_observaciones_y_concluciones.*

class ObservacionesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(
            R.layout.fragment_encuesta_observaciones_y_concluciones,
            container,
            false
        )
        val finalizar: Button = root.findViewById(R.id.finalizar)
        finalizar.setOnClickListener() {
            if (observacion.text.toString() == "") {
                Toasty.error(
                    contexto,
                    "Por favor llenar el campo de observaciones",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val respuestas = arguments
                if (respuestas != null) {
                    //recoger todas las respuestas y guardarla en un objeto para enviarla a base de datos
                }
            }
        }
        return root
    }
}