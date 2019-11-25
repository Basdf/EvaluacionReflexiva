package com.saludpublica.evred.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.saludpublica.evred.R


class SendFragment : Fragment() {
    var numeroC =1
    var textId="CompromisoNumero"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(R.layout.fragment_encuesta_compromiso, container, false)
        val addButton :ImageButton= root.findViewById(R.id.AddButton)
        val ll = root.findViewById(R.id.layout) as LinearLayout
        addButton.setOnClickListener(){
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val editText = EditText(context)
            numeroC++
            editText.id=numeroC
            ll.addView(editText,params)

        }
        return root
    }
}