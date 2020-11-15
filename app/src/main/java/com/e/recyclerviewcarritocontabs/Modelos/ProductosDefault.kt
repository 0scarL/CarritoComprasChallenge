package com.e.recyclerviewcarritocontabs.Modelos


import com.e.recyclerviewcarritocontabs.R

class ProductosDefault {

    var producto1 = Productos("Balon", 70000.0, "Su superficie es sin costuras, lo que permite una trayectoria más predecible, mejor toque y una menor absorción de agua.", R.drawable.balon_brazil2014)
    var producto2 = Productos("Camiseta", 120000.0, "Camiseta de Selección Colombia, " +
            "esta camiseta fue vestida por la selección en el mundial de Brazil 2014, donde colombia ha tenido su " +
            "mejor participación."
            , R.drawable.camiseta_seleccion2014 )
    var producto3 = Productos("Laptop", 1_300_000.0,"Laptop Asus 5i Núcleos  duo, este pc ofrece desempeño " +
            " óptimo de sonido, 500Gb disco estado sólido, 8Gb ram, Usb 5.", R.drawable.laptop)
    var producto4 = Productos("Bicicleta", 650000.0, null, R.drawable.bicicleta)
    var producto5 = Productos("zapatos", 80000.0, null, null )


    fun doList(){
        ListaProductos.addProduct(producto1)
        ListaProductos.addProduct(producto2)
        ListaProductos.addProduct(producto3)
        ListaProductos.addProduct(producto4)
        ListaProductos.addProduct(producto5)

    }

}