package model

import com.example.spotifyclone.R
import com.google.gson.annotations.SerializedName

data class Categoria(

    @SerializedName("titulo") var titulo: String = "",
    @SerializedName("albuns") var albuns: List<Album> = arrayListOf()
)

    class Album(
        @SerializedName("url_imagem") var album: String = "",
        @SerializedName("id") var id: Int = 0

    )

data class  Categorias(@SerializedName("categoria")

val categorias: List<Categoria>

)

data class Secao(
    var secao: Int,
    var nomeSecao: String
)

class SecaoBuilder {
    var secao: Int = 0
    var nomeSecao: String = ""

    fun build(): Secao = Secao(secao, nomeSecao)
}

fun secao(block: SecaoBuilder.() -> Unit): Secao = SecaoBuilder().apply(block).build()

fun dados(): MutableList<Secao> = mutableListOf(

    secao {
        secao = R.drawable.yellow
        nomeSecao = "Podcasts"
    },
    secao {
        secao = R.drawable.blue_light
        nomeSecao = "Lançamentos"
    },
    secao {
        secao = R.drawable.orange
        nomeSecao = "Brasil"
    },
    secao {
        secao = R.drawable.gray_light
        nomeSecao = "Funk"
    }
)