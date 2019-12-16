package com.saludpublica.evred.ui.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saludpublica.evred.R

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var materias: MutableList<MateriasModel> = ArrayList()
    lateinit var context: Context

    fun HomeAdapter(materias : MutableList<MateriasModel>, context: Context){
        this.materias = materias
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = materias.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.materias_view, parent, false))
    }

    override fun getItemCount(): Int {
        return materias.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById(R.id.Nombre) as TextView
        val profesor = view.findViewById(R.id.Profesor) as TextView

        fun bind(materias:MateriasModel, context: Context){
            nombre.text = materias.nombre
            profesor.text = materias.profesor

        }

    }
}
