package com.example.spotifyclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spotifyclone.R


class Home : Fragment() {

    companion object {
        fun newInstance(): Home{
            val fragmentHome = Home()
            var argumentos = Bundle()
            fragmentHome.arguments = argumentos
            return fragmentHome
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



    }

    private inner class CategoriaAdapter(private val categorias)
}