package com.example.spotifyclone.Fragments

import android.graphics.Insets.add
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.view.ViewPager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
import com.example.spotifyclone.FragmentsTab.Albuns
import com.example.spotifyclone.FragmentsTab.Artistas
import com.example.spotifyclone.FragmentsTab.Playlists
import com.example.spotifyclone.R
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager





class Biblioteca : android.support.v4.app.Fragment() {

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
        var adapter = FragmentPagerItemAdapter(requireActivity().supportFragmentManager, FragmentPagerItems.with(context)
            .add("Playlists", Playlists::class.java)
            .add("Artistas", Artistas::class.java)
            .add("Álbuns", Albuns::class.java)
            .create()
        )

        val viewpager = view.findViewById<ViewPager>(R.id.viewpager)
        val viewpagertab = view.findViewById<ViewPager>(R.id.viewpagertab)
        viewpager.adapter = adapter
        viewpagertab.setViewPager(viewpager)
    }

}




