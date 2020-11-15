package com.e.recyclerviewcarritocontabs.Adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.recyclerviewcarritocontabs.Interfaz.CarritoListener
import com.e.recyclerviewcarritocontabs.Modelos.ListaCarrito
import com.e.recyclerviewcarritocontabs.Modelos.Productos
import com.e.recyclerviewcarritocontabs.R

class CarritoAdapter(var listado: MutableList<Productos>, var listener : CarritoListener) : RecyclerView.Adapter<CarritoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_carrito, parent, false)
        return CarritoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        holder.bind(listado[position], listener)
    }
}