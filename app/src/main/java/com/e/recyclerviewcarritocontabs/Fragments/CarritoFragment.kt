package com.e.recyclerviewcarritocontabs.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.recyclerviewcarritocontabs.Adaptadores.CarritoAdapter
import com.e.recyclerviewcarritocontabs.Interfaz.CarritoListener
import com.e.recyclerviewcarritocontabs.Modelos.ListaCarrito
import com.e.recyclerviewcarritocontabs.Modelos.Productos
import com.e.recyclerviewcarritocontabs.R
import kotlinx.android.synthetic.main.fragment_carrito.*
import kotlinx.android.synthetic.main.fragment_carrito.view.*
import kotlinx.android.synthetic.main.layout_item_carrito.*
import kotlinx.android.synthetic.main.layout_item_carrito.view.*
import kotlin.reflect.typeOf
/**implemento la interfaz CarritoListener y la paso al adaptador y viewholder para q estos puedan notificar el adaptador cambio**/
class CarritoFragment : Fragment(), CarritoListener  {

    var carritoAdapter : CarritoAdapter? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.fragment_carrito, container, false)
        // Inflate the layout for this fragment

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carritoAdapter = CarritoAdapter(ListaCarrito.listaCarrito, this)
        view.myRecyclerView_carrito.adapter = carritoAdapter
        view.myRecyclerView_carrito.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)



    }


    /**metodo para refrescar la vista de los fragments**/
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        reloadCarrito()

    }

    override fun reloadCarrito(){
        carritoAdapter?.listado = ListaCarrito.listaCarrito
        carritoAdapter?.notifyDataSetChanged()
        /**con este codigo hago llamado a la funcion totalizar que suma el total de la compra**/
        if(!ListaCarrito.listaCarrito.isEmpty()){layot_carrito_total.text = totalizar()
        } else layot_carrito_total?.text = "Total a comprar : $ 0.0"
    }

    fun totalizar(): String{
        var resultado = 0.0
        for(item in ListaCarrito.listaCarrito){
            resultado = item.amount*item.precio + resultado
        }
        return "${"Total Compra= $ "}${resultado.toString()}"
    }


}