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
import kotlinx.android.synthetic.main.fragment_encuesta_aspectos_generales_del_curso.*

class AspectosGeneralesFragment : Fragment() {

    private lateinit var encuestaEstudianteModel: EncuestaEstudianteModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(
            R.layout.fragment_encuesta_aspectos_generales_del_curso,
            container,
            false
        )

        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {

            val respuesta1 = respuesta1.checkedRadioButtonId
            val respuesta2 = respuesta2.checkedRadioButtonId
            val respuesta3 = respuesta3.checkedRadioButtonId
            when {
                respuesta1 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 1",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta2 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 2",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta3 == -1 -> Toasty.error(
                    contexto,
                    "Por favor responder la pregunta 3",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = ObjetivosFragment()
                    //cambiar esto por una forma mas eficiente
                    val respuestas = Bundle()
                    respuestas.putInt("respuesta1", 1)//poner hay la respuesta de la pregunta
                    respuestas.putInt("respuesta2", 1)
                    respuestas.putInt("respuesta3", 1)
                    fragment.arguments = respuestas
                    fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                    fragmentTransaction?.commit()
                }
            }
        }

        return root
    }
}