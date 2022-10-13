package com.example.tarotfirst.fortune

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotfirst.R
import com.example.tarotfirst.cardClasses.Tarot


class CardOfTheDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singlecard) // as on LinkCardActivity

        shuffleTarot()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun shuffleTarot() {
        // create new Tarot object with 78 sides and shuffle it
        val tarot = Tarot()
        val tarotShuffle = tarot.shuffle(0, 10)

        // find the ImageView in the layout
        val resultImageView: ImageView = findViewById(R.id.imageView)
        val resourceDraw = resources.getIdentifier(
            "tarot_$tarotShuffle",
            "drawable",
            "com.example.tarotfirst"
        )

        // update the screen with the tarot shuffle
        val resultCardView: TextView = findViewById(R.id.cardName)
        val resourceCard = resources.getIdentifier(
            "tarot_$tarotShuffle",
            "string",
            "com.example.tarotfirst"
        )

        // update the screen with the tarot description
        val resultTextView: TextView = findViewById(R.id.cardDesc)
        val resourceText = resources.getIdentifier(
            "tarotDescribing_$tarotShuffle",
            "string",
            "com.example.tarotfirst"
        )
        resultTextView.movementMethod = ScrollingMovementMethod()

        // determine which drawable resource ID to use based on the tarot shuffle
        // update the ImageView with the correct drawable resource ID
        resultImageView.setImageResource(resourceDraw)

        // update the card text from string
        resultCardView.setText(resourceCard)

        // update the description of card
        resultTextView.setText(resourceText)

        // update the content description
        resultImageView.contentDescription = tarotShuffle.toString()
    }
}