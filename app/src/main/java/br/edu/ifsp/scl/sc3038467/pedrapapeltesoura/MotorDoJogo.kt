package br.edu.ifsp.scl.sc3038467.pedrapapeltesoura

class MotorDoJogo {
    fun calcularResultado2Jogadores(jogador: Jogada, app: Jogada): String {
        if (jogador == app) return "Empate!"

        val jogadorVence = (jogador == Jogada.PEDRA && app == Jogada.TESOURA) ||
                (jogador == Jogada.PAPEL && app == Jogada.PEDRA) ||
                (jogador == Jogada.TESOURA && app == Jogada.PAPEL)

        return if (jogadorVence) "Vitória!" else "Derrota!"
    }
}