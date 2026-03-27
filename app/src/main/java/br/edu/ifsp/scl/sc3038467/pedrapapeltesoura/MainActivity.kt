package br.edu.ifsp.scl.sc3038467.pedrapapeltesoura

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var rgJogadores: RadioGroup
    private lateinit var ivApp1: ImageView
    private lateinit var ivApp2: ImageView
    private lateinit var tvResultado: TextView

    private val motor = MotorDoJogo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rgJogadores = findViewById(R.id.rgJogadores)
        ivApp1 = findViewById(R.id.ivApp1)
        ivApp2 = findViewById(R.id.ivApp2)
        tvResultado = findViewById(R.id.tvResultado)

        rgJogadores.setOnCheckedChangeListener { _, checkedId ->
            ivApp2.visibility = if (checkedId == R.id.rbTresJogadores) View.VISIBLE else View.GONE
        }
        findViewById<ImageButton>(R.id.ibPedra).setOnClickListener { jogar(Jogada.PEDRA) }
        findViewById<ImageButton>(R.id.ibPapel).setOnClickListener { jogar(Jogada.PAPEL) }
        findViewById<ImageButton>(R.id.ibTesoura).setOnClickListener { jogar(Jogada.TESOURA) }
    }

    private fun atualizarImagem(imageView: ImageView, jogada: Jogada) {
        val drawableId = when (jogada) {
            Jogada.PEDRA -> R.drawable.pedra
            Jogada.PAPEL -> R.drawable.papel
            Jogada.TESOURA -> R.drawable.tesoura
        }
        imageView.setImageResource(drawableId)
    }

    private fun jogar(jogadaUsuario: Jogada) {
        val jogadaApp1 = Jogada.entries.random()
        atualizarImagem(ivApp1, jogadaApp1)

        if (rgJogadores.checkedRadioButtonId == R.id.rbTresJogadores) {
            val jogadaApp2 = Jogada.entries.random()
            atualizarImagem(ivApp2, jogadaApp2)
            tvResultado.text = motor.calcularResultado3Jogadores(jogadaUsuario, jogadaApp1, jogadaApp2)
        } else {
            tvResultado.text = motor.calcularResultado2Jogadores(jogadaUsuario, jogadaApp1)
        }
    }
}