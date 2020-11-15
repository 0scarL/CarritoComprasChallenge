package com.e.recyclerviewcarritocontabs.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.recyclerviewcarritocontabs.Adaptadores.TabsAdaptador
import com.e.recyclerviewcarritocontabs.Modelos.ProductosDefault
import com.e.recyclerviewcarritocontabs.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**Agrega launch icon y app icon**/
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_gorillaz)


        /**Genero listado por default de algunos productos**/
        ProductosDefault().doList()

        /**Luego de crear el TabAdapter, ahora lo seteo**/
        myViewPager.adapter = TabsAdaptador(supportFragmentManager)
        /**configuro el viewPager y tabs**/
        myTabLayout.setupWithViewPager(myViewPager)




    }
}