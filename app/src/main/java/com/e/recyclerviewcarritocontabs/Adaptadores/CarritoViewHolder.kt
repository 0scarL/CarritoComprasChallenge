package com.e.recyclerviewcarritocontabs.Adaptadores

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.e.recyclerviewcarritocontabs.Modelos.ListaCarrito
import com.e.recyclerviewcarritocontabs.Modelos.Productos
import kotlinx.android.synthetic.main.layout_item_carrito.view.*
import com.e.recyclerviewcarritocontabs.Fragments.CarritoFragment
import com.e.recyclerviewcarritocontabs.Interfaz.CarritoListener
import com.e.recyclerviewcarritocontabs.R
import kotlinx.android.synthetic.main.fragment_carrito.view.*


class CarritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val IMAGE_DEFAULT = com.e.recyclerviewcarritocontabs.R.drawable.vacio

    fun bind(item: Productos, listener: CarritoListener){

        itemView.layot_carrito_nombreProducto.text = item.nombreProducto
        if(item.foto == null) itemView.layout_carrito_imagenProducto.setImageResource(IMAGE_DEFAULT)
        else {
            itemView.layout_carrito_imagenProducto.setImageResource(item.foto!!)
        }
        itemView.layot_carrito_precio.text = "${"$ "}${item.precio.toString()}"
        itemView.layout_carrito_amount.text = "${"Qty: "}${item.amount.toString()}"
        if(item.detalle == null){ itemView.layout_carrito_descripcion.text = "No hay descripción del producto"}
        else {
            itemView.layout_carrito_descripcion.text = item.detalle.toString()
        }
        if(!ListaCarrito.listaCarrito.isEmpty()){

            itemView.layot_carrito_web.setOnClickListener { view: View? ->
                Toast.makeText(itemView.context, "Envio de mails! " , Toast.LENGTH_SHORT).show()
                sendMail(itemView)
                  }

            itemView.layout_carrito_imagenProducto.setOnLongClickListener { view -> showAlert(view, item, listener) }
        }



    }

    /** este metdoo para enviar mail hay q impelemmentarlo en el viewholder**/
    private fun sendMail(itemView: View){
        val intentMail = Intent(Intent.ACTION_SEND, Uri.parse("mailto:"))
        intentMail.putExtra(Intent.EXTRA_EMAIL, "o.lizarazob@gmail.com")
        intentMail.putExtra(Intent.EXTRA_SUBJECT,"Consulta de Articulo en venta")
        intentMail.putExtra(Intent.EXTRA_TEXT,"Hola Oscar, he visto tu articulo en venta y quisera.....")
        intentMail.type = "text/plain"

        val shareIntent = Intent.createChooser(intentMail, null)
        itemView.context.startActivity(shareIntent)

    }

    private fun showAlert(view: View, item: Productos, listener: CarritoListener):Boolean{
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Opciones de tus Compras")
        builder.setPositiveButton("Quiero otr@ "+item.nombreProducto){dialogInterface, i ->
            ListaCarrito.addCarrito(item)
            listener.reloadCarrito()
        }
        builder.setNegativeButton("Quitar un@ "+item.nombreProducto){dialogInterface, i ->
            ListaCarrito.removeCarrito(item)
            listener.reloadCarrito()
        }
        builder.setNeutralButton("Vaciar todo el carrito"){dialogInterface, i ->
            ListaCarrito.listaCarrito.clear()
            listener.reloadCarrito()
        }

        builder.create()
        builder.show()
        return true
    }
}