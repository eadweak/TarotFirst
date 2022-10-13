package com.example.tarotfirst.fortune

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotfirst.R
import com.example.tarotfirst.cardClasses.Tarot


class OracleActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)

        oracleCross()

    }

    @SuppressLint("ResourceType")
    private fun oracleCross() {
        // preparing random fix functional for return number of card
        val tarot = Tarot()
        var tarotShuffleOne = tarot.shuffle(0, 10)
        var tarotShuffleTwo = tarot.shuffle(0, 10)
        var tarotShuffleThree = tarot.shuffle(0, 10)

        // re-check for similar value
        when (tarotShuffleOne) {
            tarotShuffleTwo -> if(tarotShuffleTwo > 0) tarotShuffleOne - 1 else tarotShuffleTwo + 1
            tarotShuffleThree -> if(tarotShuffleThree > 0) tarotShuffleOne - 1 else tarotShuffleThree + 1
        }

        // fixing image for ImageViews of cards
        val layoutCard1: ImageView = findViewById(R.id.oracleCardOne)
        val layoutCard2: ImageView = findViewById(R.id.oracleCardTwo)
        val layoutCard3: ImageView = findViewById(R.id.oracleCardThree)

        // make visible/invisible buttons
        fun View.toggleVisibility() {
            if (visibility == View.VISIBLE) {
                visibility = View.INVISIBLE
            } else {
                visibility = View.VISIBLE
            }
        }

        // toggle views
        layoutCard1.toggleVisibility()
        layoutCard2.toggleVisibility()
        layoutCard3.toggleVisibility()

        // fixing description for cards
        val textCard: TextView = findViewById(R.id.oracleText)

        // fixing resources of cards
        val resourceTextOne = resources.getIdentifier(
            "tarotDescribing_$tarotShuffleOne",
            "string",
            "com.example.tarotfirst"
        )
        val resourceTextTwo = resources.getIdentifier(
            "tarotDescribing_$tarotShuffleTwo",
            "string",
            "com.example.tarotfirst"
        )
        val resourceTextThree = resources.getIdentifier(
            "tarotDescribing_$tarotShuffleThree",
            "string",
            "com.example.tarotfirst"
        )

        // randomly define cards on layouts
        val resourceDraw1 = resources.getIdentifier(
            "tarot_$tarotShuffleOne",
            "drawable",
            "com.example.tarotfirst"
        )

        val resourceDraw2 = resources.getIdentifier(
            "tarot_$tarotShuffleTwo",
            "drawable",
            "com.example.tarotfirst"
        )

        val resourceDraw3 = resources.getIdentifier(
            "tarot_$tarotShuffleThree",
            "drawable",
            "com.example.tarotfirst"
        )

        // create booleans for determine the number of button presses
        var textOneTrue = false
        var textTwoTrue = false
        var textThreeTrue = false

        // define function to add text after clicking on cards
        @SuppressLint("SetTextI18n")
        fun afterClick() {
            textCard.text = getString(R.string.header_love) + "\n" + getString(resourceTextOne) +
                    "\n\n" + getString(R.string.header_fate) + "\n" + getString(resourceTextTwo) +
                    "\n\n" + getString(R.string.header_career) + "\n" + getString(resourceTextThree)
            textCard.movementMethod = ScrollingMovementMethod()
        }

        // define click listener for card's descriptions
        layoutCard1.setOnClickListener {
            layoutCard1.setImageResource(resourceDraw1)
            textOneTrue = true
            if (textTwoTrue && textThreeTrue) {
                afterClick()
            }
        }

        layoutCard2.setOnClickListener {
            layoutCard2.setImageResource(resourceDraw2)
            textTwoTrue = true
            if (textOneTrue && textThreeTrue) {
                afterClick()
            }
        }

        layoutCard3.setOnClickListener {
            layoutCard3.setImageResource(resourceDraw3)
            textThreeTrue = true
            if (textOneTrue && textTwoTrue) {
                afterClick()
            }
        }

        // update the content description
        layoutCard1.contentDescription = tarotShuffleOne.toString()
        layoutCard2.contentDescription = tarotShuffleTwo.toString()
        layoutCard3.contentDescription = tarotShuffleThree.toString()

    }
}