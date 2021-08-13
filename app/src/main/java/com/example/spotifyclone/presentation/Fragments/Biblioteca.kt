package com.example.spotifyclone.presentation.Fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spotifyclone.presentation.FragmentsTab.Albuns
import com.example.spotifyclone.presentation.FragmentsTab.Artistas
import com.example.spotifyclone.presentation.FragmentsTab.Playlists
import com.example.spotifyclone.R
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

import androidx.viewpager.widget.ViewPager
import com.ogaclejapan.smarttablayout.SmartTabLayout


class Biblioteca : Fragment(){

    companion object {
        fun newInstance(): Biblioteca{
            val fragmentBiblioteca = Biblioteca()
            var argumentos = Bundle()
            fragmentBiblioteca.arguments = argumentos
            return fragmentBiblioteca
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biblioteca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var adapter = FragmentPagerItemAdapter(activity?.supportFragmentManager, FragmentPagerItems.with(context)
            .add("Playlists", Playlists::class.java)
            .add("Artistas", Artistas::class.java)
            .add("Álbuns", Albuns::class.java)
            .create()
        )

        val viewpager = view.findViewById<ViewPager>(R.id.viewpager)
        val viewpagertab = view.findViewById<SmartTabLayout>(R.id.viewpagertab)
        viewpager.adapter = adapter
        viewpagertab.setViewPager(viewpager)
    }

}




