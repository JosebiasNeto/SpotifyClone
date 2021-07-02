package com.example.spotifyclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone.R
import model.Categoria
import com.example.spotifyclone.R.layout.categoria_item


class Home : Fragment() {

    private lateinit var categoriaAdapter: CategoriaAdapter

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

        val categorias: MutableList<Categoria> = ArrayList()
        for (c in 0..4){
            val categoria = Categoria()
            categoria.titulo = "Categoria$c"

            categorias.add(categoria)
        }


        categoriaAdapter = CategoriaAdapter(categorias)
        view.findViewById<RecyclerView>(R.id.recycler_view_categorias).adapter = categoriaAdapter
        view.findViewById<RecyclerView>(R.id.recycler_view_categorias).layoutManager = LinearLayoutManager(context)


    }

    private inner class CategoriaAdapter(private val categorias: MutableList<Categoria>): RecyclerView.Adapter<CategoriaHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder {
            return CategoriaHolder(layoutInflater.inflate(R.layout.categoria_item, parent, false))
        }

        override fun onBindViewHolder(holder: CategoriaHolder, position: Int) {
            val categoria = categorias[position]
            holder.bind(categoria)
        }

        override fun getItemCount(): Int = categorias.size
    }

    private inner class CategoriaHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(categoria: Categoria){
            itemView.findViewById<TextView>(R.id.tv_titulo).text = categoria.titulo
        }
    }
}