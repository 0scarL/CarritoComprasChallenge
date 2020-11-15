package com.e.recyclerviewcarritocontabs.Adaptadores


import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.e.recyclerviewcarritocontabs.Modelos.ListaCarrito
import com.e.recyclerviewcarritocontabs.Modelos.Productos
import kotlinx.android.synthetic.main.layout_item_productos.view.*

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /**si el articulo no tiene foto entonces se muestra imagen de default**/
    val IMAGE_DEFAULT : Int = com.e.recyclerviewcarritocontabs.R.drawable.vacio

    fun bind(item: Productos){

        itemView.layot_item_textView_nombreProducto.text = item.nombreProducto
        itemView.layot_item_textView_precio.text = "$ ${item.precio.toString()}"

        if(item.detalle == null) itemView.layot_item_detalles.text = "No hay descripción del producto"
        else {
            /** se pasa el detalle de cada producto al metodo acotar**/
            val mensajeAcotado = acotar(item.detalle.toString())
            itemView.layot_item_detalles.text = mensajeAcotado
        }
        if(item.foto == null) itemView.layout_item_imageView.setImageResource(IMAGE_DEFAULT)
        else {
            itemView.layout_item_imageView.setImageResource(item.foto!!)
        }

        itemView.layout_item_botonComprar.setOnClickListener { view ->

            ListaCarrito.addCarrito(item)
            Toast.makeText(itemView.context, "catidad "+item.nombreProducto+" "+item.amount, Toast.LENGTH_SHORT).show()
        }
    }

    /**cuando los detalles de un producto sean mayor a 40 caracteres entonces se reemplaza por ...**/
    fun acotar(detalle: String):String{
        var mensajeAcotado = ""
        val longitud = detalle.length
        if(longitud>40){mensajeAcotado = "${detalle.substring(0, 39)}${"..."}"}
        else {mensajeAcotado = detalle}
        return mensajeAcotado
        }

    }
