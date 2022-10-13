package com.example.tarotfirst.lists

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotfirst.fortune.CompatActivity
import com.example.tarotfirst.fortune.OracleActivity
import com.example.tarotfirst.R
import com.example.tarotfirst.fortune.SevenStarsActivity
import com.example.tarotfirst.cardClasses.Card

class ReadingCardsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_readingcards)

        val readsView = findViewById<ListView>(R.id.listViewRead)
        val list = mutableListOf<Card>()

        // intents of layout activities
        var intentOracle = Intent(this, OracleActivity::class.java)
        var intentCeltic = Intent(this, SevenStarsActivity::class.java)
        var intentCompat = Intent(this, CompatActivity::class.java)

        list.add(Card("Оракул", "Этот расклад прекрасно подходит для анализа любой проблемы.",
            R.drawable.tarot_0))
        list.add(Card("Кельтский крест", "Если вам трудно решить, какой расклад лучше подойдет для ответа на ваш вопрос, используйте «Кельтский крест» - и вы не ошибетесь.",
            R.drawable.tarot_1))
        list.add(Card("Расклад на совместимость", "Этот расклад Таро полностью фокусируется на динамике отношений между двумя партнерами и анализирует различные аспекты ваших отношений, которые могут быть точками разногласий или объединения.",
            R.drawable.tarot_2))

        readsView.adapter = MyListAdapter(this, R.layout.item_pod, list)

        // find card position and show its description
        readsView.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                intentOracle.putExtra("FirstRead", position.toString())
                startActivity(intentOracle)
            } else if (position == 1) {
                intentCeltic.putExtra("SecondRead", position.toString())
                startActivity(intentCeltic)
            } else if (position == 2) {
                intentCompat.putExtra("ThirdRead", position.toString())
                startActivity(intentCompat)
            }
        }
    }
}