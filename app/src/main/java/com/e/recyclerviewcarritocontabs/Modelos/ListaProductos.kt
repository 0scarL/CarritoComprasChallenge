package com.e.recyclerviewcarritocontabs.Modelos

object ListaProductos {

    var listadoProductos : MutableList<Productos> = mutableListOf()

    fun addProduct(item: Productos) {
        if(listadoProductos.contains(item)) return
        else{
            listadoProductos.add(item)}
    }
}