

package com.e.recyclerviewcarritocontabs.Adaptadores

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.e.recyclerviewcarritocontabs.Fragments.CarritoFragment
import com.e.recyclerviewcarritocontabs.Fragments.ProductFragment


class TabsAdaptador(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
    val NUMERO_TABS = 2

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return ProductFragment()
            else -> return CarritoFragment()}
        }

    override fun getCount(): Int {
        return NUMERO_TABS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Productos"
            else -> return "Carrito"}
    }
}