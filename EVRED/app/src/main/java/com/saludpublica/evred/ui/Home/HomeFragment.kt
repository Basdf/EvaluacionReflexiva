package com.saludpublica.evred.ui.Home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saludpublica.evred.R
import es.dmoral.toasty.Toasty

class HomeFragment : Fragment(), HomeAdapter.OnclickInterface {
    lateinit var view: Context


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        view=root.context
        val context=root.context
        lateinit var mRecyclerView: RecyclerView
        val mAdapter = HomeAdapter()


        mRecyclerView = root.findViewById(R.id.rvMaterias) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter.HomeAdapter(getMaterias(),this)
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

    override fun onItemClick(position: Int) {
        Toasty.success(
            view,
            "hola :V",
            Toast.LENGTH_LONG
        ).show()
    }
}