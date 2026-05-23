package com.example.myapplication

object ShowRepository {
    fun getShowsFicticios(): List<Show> {
        return listOf(
            Show(1, "Coldplay", "São Paulo", "Estádio do MorumBIS", "25/10/2026", urlCompra = "https://www.ticketmaster.com.br"),
            Show(2, "Taylor Swift", "Rio de Janeiro", "Estádio Nilton Santos", "12/11/2026", urlCompra = "https://www.eventim.com.br"),
            Show(3, "Vintage Culture", "Belo Horizonte", "Mineirão", "05/12/2026", urlCompra = "https://www.sympla.com.br"),
            Show(4, "Iron Maiden", "São Paulo", "Allianz Parque", "18/12/2026", urlCompra = "https://www.livepass.com.br"),
            Show(5, "Anitta", "Salvador", "Arena Fonte Nova", "20/01/2027", urlCompra = "https://www.ticketmaster.com.br"),
            Show(6, "Alok", "Florianópolis", "P12", "31/12/2026", urlCompra = "https://www.sympla.com.br")
        )
    }

    // Show de destaque do topo
    fun getShowDestaque(): Show {
        return Show(99, "Rock in Rio 2026", "Rio de Janeiro", "Cidade do Rock", "Setembro/2026", urlCompra = "https://www.ticketmaster.com.br")
    }
}