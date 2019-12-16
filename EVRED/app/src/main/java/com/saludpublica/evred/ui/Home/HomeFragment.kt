package com.saludpublica.evred.ui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saludpublica.evred.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contexto = activity!!.applicationContext
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        lateinit var mRecyclerView: RecyclerView
        val mAdapter = HomeAdapter()


        mRecyclerView = root.findViewById(R.id.rvMaterias) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(contexto)
        mAdapter.HomeAdapter(getMaterias(), contexto)
        mRecyclerView.adapter = mAdapter




        return root
    }

    fun getMaterias(): MutableList<MateriasModel> {
        var superheros: MutableList<MateriasModel> = ArrayList()
        superheros.add(
            MateriasModel(
                "Spiderman",
                "Marvel"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "DC"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "Marvel"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "DC"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "Marvel"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "DC"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "Marvel"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "DC"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "Marvel"
            )
        )
        superheros.add(
            MateriasModel(
                "Spiderman",
                "DC"
            )
        )

        return superheros
    }
}