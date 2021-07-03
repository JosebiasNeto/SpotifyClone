package model

class Categoria(

    var titulo: String = "",
    var albuns: MutableList<Album> = ArrayList()
)

    class Album(
        var album: Int = 0
    )