package com.e.recyclerviewcarritocontabs.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.recyclerviewcarritocontabs.Adaptadores.ProductAdapter
import com.e.recyclerviewcarritocontabs.Modelos.ListaProductos
import com.e.recyclerviewcarritocontabs.Modelos.Productos
import com.e.recyclerviewcarritocontabs.R
import kotlinx.android.synthetic.main.fragment_product.*
import kotlinx.android.synthetic.main.fragment_product.view.*
import java.util.*

class ProductFragment : Fragment() {

    var busqueda : String =""
    var adaptador = ProductAdapter(ListaProductos.listadoProductos)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    @SuppressLint("DefaultLocale")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        myRecyclerView.adapter = adaptador
        myRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false )

        view.imageView_buscar.setOnClickListener {
            busqueda = editText_buscar.text.toString().toLowerCase()
            filtrar()
            /**para renderizar esta nueva lista, que es la filtrada entonces uso el mismo adaptador de Productos**/

        }
    }

        fun filtrar() {
            val listaFiltrada : MutableList<Productos> = mutableListOf()
            for(item in ListaProductos.listadoProductos){
                if(item.nombreProducto.toLowerCase(Locale.ROOT).contains(busqueda)){
                    listaFiltrada.add(item)
                    }
            }
            adaptador.listaProdcutos = listaFiltrada
            adaptador.notifyDataSetChanged()
        }

    }

