package com.example.spotifyclone.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone.Detalhes
import com.example.spotifyclone.R
import com.example.spotifyclone.R.layout.categoria_item
import com.squareup.picasso.Picasso
import model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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



        val categorias = arrayListOf<Categoria>()
        categoriaAdapter = CategoriaAdapter(categorias)
        view.findViewById<RecyclerView>(R.id.recycler_view_categorias).adapter = categoriaAdapter
        view.findViewById<RecyclerView>(R.id.recycler_view_categorias).layoutManager = LinearLayoutManager(context)

        retrofit().create(SpotifyAPI::class.java)
            .ListCategorias()
            .enqueue(object : Callback<Categorias>{
                override fun onFailure(call: Call<Categorias>, t: Throwable) {
                    Toast.makeText(context, "Erro no servidor.", Toast.LENGTH_SHORT).show()
                              }

                override fun onResponse(call: Call<Categorias>, response: Response<Categorias>) {
                    if (response.isSuccessful){
                        response.body()?.let {
                            categoriaAdapter.categorias.clear()
                            categoriaAdapter.categorias.addAll(it.categorias)
                            categoriaAdapter.notifyDataSetChanged()
                        }
                    }
                }
            })
    }

    private inner class CategoriaAdapter(internal val categorias: MutableList<Categoria>): RecyclerView.Adapter<CategoriaHolder>() {
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
            itemView.findViewById<RecyclerView>(R.id.recycler_albuns).adapter = AlbunsAdapter(categoria.albuns){ album ->

                val intent = Intent(context, Detalhes::class.java)
                intent.putExtra("album", album.album)
                intent.putExtra("titulo", titulos[album.id])
                startActivity(intent)

            }
            itemView.findViewById<RecyclerView>(R.id.recycler_albuns).layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }

    //////////////---------------------------------------------------------------------

    private inner class AlbunsAdapter(private val albuns: List<Album>, private val listener: ((Album) -> Unit)?): RecyclerView.Adapter<AlbunsHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbunsHolder =
            AlbunsHolder(layoutInflater.inflate(R.layout.album_item, parent, false), listener)


        override fun onBindViewHolder(holder: AlbunsHolder, position: Int) {
            val album = albuns[position]
            holder.bind(album)
        }

        override fun getItemCount(): Int = albuns.size
    }

    private inner class AlbunsHolder(itemView: View, val onClick: ((Album) -> Unit)?): RecyclerView.ViewHolder(itemView){
        fun bind(album: Album){
           // itemView.findViewById<ImageView>(R.id.iv_album).setImageResource(album.album)
            if (album.album.isEmpty()){
                itemView.findViewById<ImageView>(R.id.iv_album).setImageResource(R.drawable.placeholder)
            } else {
                Picasso.get().load(album.album).placeholder(R.drawable.placeholder).fit()
                    .into(itemView.findViewById<ImageView>(R.id.iv_album))
                itemView.findViewById<ImageView>(R.id.iv_album).setOnClickListener {
                    onClick?.invoke(album)
                }
            }
        }
    }


}