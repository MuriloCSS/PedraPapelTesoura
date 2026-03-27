package br.edu.ifsp.scl.sc3038467.pedrapapeltesoura

class MotorDoJogo {
    fun calcularResultado2Jogadores(jogador: Jogada, app: Jogada): String {
        if (jogador == app) return "Empate!"

        val jogadorVence = (jogador == Jogada.PEDRA && app == Jogada.TESOURA) ||
                (jogador == Jogada.PAPEL && app == Jogada.PEDRA) ||
                (jogador == Jogada.TESOURA && app == Jogada.PAPEL)

        return if (jogadorVence) "Vitória!" else "Derrota!"
    }

    fun calcularResultado3Jogadores(jogador: Jogada, app1: Jogada, app2: Jogada): String {
        val jogadas = listOf(jogador, app1, app2)
        val distintas = jogadas.toSet()

        if (distintas.size == 1 || distintas.size == 3) return "Empate geral!"

        val contagem = jogadas.groupingBy { it }.eachCount()
        val jogadaUnica = contagem.filterValues { it == 1 }.keys.first()
        val jogadaDupla = contagem.filterValues { it == 2 }.keys.first()

        val unicaVence = (jogadaUnica == Jogada.PEDRA && jogadaDupla == Jogada.TESOURA) ||
                (jogadaUnica == Jogada.PAPEL && jogadaDupla == Jogada.PEDRA) ||
                (jogadaUnica == Jogada.TESOURA && jogadaDupla == Jogada.PAPEL)

        return if (unicaVence) {
            if (jogador == jogadaUnica) "Vitória! Você venceu sozinho!" else "Derrota! Um Bot venceu!"
        } else {
            if (jogador == jogadaDupla) "Vitória dividida com um Bot!" else "Derrota! Os Bots venceram!"
        }
    }
}