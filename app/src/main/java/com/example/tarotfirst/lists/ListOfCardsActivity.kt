package com.example.tarotfirst.lists

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotfirst.fortune.LinkCardActivity
import com.example.tarotfirst.R
import com.example.tarotfirst.cardClasses.Card
import java.lang.reflect.Array.getInt

class ListOfCardsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listofcards)

        val cardsView = findViewById<ListView>(R.id.listView)
        val list = mutableListOf<Card>()
        var intentLinkCard = Intent(this, LinkCardActivity::class.java)

        // add Card values
        for (i in 0..10) {
            var resourceString = resources.getIdentifier("tarot_$i", "string", "com.example.tarotfirst")
            var resourceDrawable = resources.getIdentifier("tarot_$i", "drawable", "com.example.tarotfirst")
            list += Card(getString(resourceString), "", resourceDrawable)
        }

        // add adapter for watching list of cards
        cardsView.adapter = MyListAdapter(this, R.layout.item_pod, list)

        cardsView.setOnItemClickListener { parent, view, position, id ->
            intentLinkCard.putExtra("Data", position.toString())
            startActivity(intentLinkCard)
        }
    }
}