@file:Suppress("UNNECESSARY_SAFE_CALL")

package com.e.recyclerviewcarritocontabs.Modelos

import com.e.recyclerviewcarritocontabs.Fragments.CarritoFragment

object ListaCarrito {

    var listaCarrito : MutableList<Productos> = mutableListOf()

     fun addCarrito (item: Productos) {
         if (listaCarrito.contains(item)) {
             item.amount = item.amount?.plus(1)

         } else {
             listaCarrito.add(item)
             item.amount = 1
         }
     }
     fun removeCarrito(item: Productos){
         if(item.amount >1 ) {
             item.amount = item.amount-1

         }
         else{
             listaCarrito.remove(item)

         }
     }


}