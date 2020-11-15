package com.e.recyclerviewcarritocontabs.Adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.recyclerviewcarritocontabs.Modelos.Productos
import com.e.recyclerviewcarritocontabs.R

class ProductAdapter(var listaProdcutos: MutableList<Productos>) : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var view =  LayoutInflater.from(parent.context).inflate(R.layout.layout_item_productos, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaProdcutos.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(listaProdcutos[position])
    }
}