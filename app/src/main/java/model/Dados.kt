package model

import com.google.gson.annotations.SerializedName

data class Categoria(

    @SerializedName("titulo") var titulo: String = "",
    @SerializedName("albuns") var albuns: List<Album> = arrayListOf()
)

    class Album(
        @SerializedName("url_image") var album: String = ""
    )

data class  Categorias(@SerializedName("categoria")

val categorias: List<Categoria>

)