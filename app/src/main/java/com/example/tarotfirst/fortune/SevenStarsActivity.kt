package com.example.tarotfirst.fortune

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotfirst.R
import com.example.tarotfirst.cardClasses.Tarot

class SevenStarsActivity : AppCompatActivity() {
    // preparing random fix functional for return number of card
    val tarot = Tarot()
    var tarotShuffleOne = tarot.shuffle(0, 3)
    var tarotShuffleTwo = tarot.shuffle(tarotShuffleOne + 1, 4)
    var tarotShuffleThree = tarot.shuffle(tarotShuffleTwo + 1, 5)
    var tarotShuffleFourth = tarot.shuffle(tarotShuffleThree + 1, 6)
    var tarotShuffleFifth = tarot.shuffle(tarotShuffleFourth + 1, 7)
    var tarotShuffleSixth = tarot.shuffle(tarotShuffleFifth + 1, 8)
    var tarotShuffleSeventh = tarot.shuffle(tarotShuffleSixth + 1, 9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)
        sevenStars()
    }

    private fun sevenStars() {
        // fixing image for ImageViews of cards
        val layoutCard1: ImageView = findViewById(R.id.cardViewFirst)
        val layoutCard2: ImageView = findViewById(R.id.cardViewSecond)
        val layoutCard3: ImageView = findViewById(R.id.cardViewThird)
        val layoutCard4: ImageView = findViewById(R.id.cardViewFifth)
        val layoutCard5: ImageView = findViewById(R.id.cardViewSeventh)
        val layoutCard6: ImageView = findViewById(R.id.cardViewEighth)
        val layoutCard7: ImageView = findViewById(R.id.cardViewNinth)

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
        layoutCard4.toggleVisibility()
        layoutCard5.toggleVisibility()
        layoutCard6.toggleVisibility()
        layoutCard7.toggleVisibility()

        // fixing description for cards
        val textCard: TextView = findViewById(R.id.bigText)

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
        val resourceTextFourth = resources.getIdentifier(
            "tarotDescribing_$tarotShuffleFourth",
            "string",
            "com.example.tarotfirst"
        )
        val resourceTextFifth = resources.getIdentifier(
            "tarotDescribing_$tarotShuffleFifth",
            "string",
            "com.example.tarotfirst"
        )
        val resourceTextSixth = resources.getIdentifier(
            "tarotDescribing_$tarotShuffleSixth",
            "string",
            "com.example.tarotfirst"
        )
        val resourceTextSeventh = resources.getIdentifier(
            "tarotDescribing_$tarotShuffleSeventh",
            "string",
            "com.example.tarotfirst"
        )

        // Randomly define cards on layouts
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
        val resourceDraw4 = resources.getIdentifier(
            "tarot_$tarotShuffleFourth",
            "drawable",
            "com.example.tarotfirst"
        )
        val resourceDraw5 = resources.getIdentifier(
            "tarot_$tarotShuffleFifth",
            "drawable",
            "com.example.tarotfirst"
        )
        val resourceDraw6 = resources.getIdentifier(
            "tarot_$tarotShuffleSixth",
            "drawable",
            "com.example.tarotfirst"
        )
        val resourceDraw7 = resources.getIdentifier(
            "tarot_$tarotShuffleSeventh",
            "drawable",
            "com.example.tarotfirst"
        )

        // create booleans for determine the number of button presses
        var textOneTrue = false
        var textTwoTrue = false
        var textThreeTrue = false
        var textFourthTrue = false
        var textFifthTrue = false
        var textSixthTrue = false
        var textSeventhTrue = false

        // define function to add text after clicking on cards
        @SuppressLint("SetTextI18n")
        fun afterClick() {
            textCard.text = "Любовь: \n" + getString(resourceTextOne) +
                    "\n\nШаги судьбы: \n" + getString(resourceTextTwo) +
                    "\n\nКарьера: \n" + getString(resourceTextThree)
            textCard.movementMethod = ScrollingMovementMethod()
        }

        // define click listener for card's descriptions
        layoutCard1.setOnClickListener {
            layoutCard1.setImageResource(resourceDraw1)
            layoutCard1.contentDescription = tarotShuffleOne.toString()
            textOneTrue = true
            if (textTwoTrue && textThreeTrue && textFourthTrue && textFifthTrue && textSixthTrue && textSeventhTrue) {
                afterClick()
            }
        }

        layoutCard2.setOnClickListener {
            layoutCard2.setImageResource(resourceDraw2)
            layoutCard2.contentDescription = tarotShuffleTwo.toString()
            textTwoTrue = true
            if (textOneTrue && textThreeTrue && textFourthTrue && textFifthTrue && textSixthTrue && textSeventhTrue) {
                afterClick()
            }
        }

        layoutCard3.setOnClickListener {
            layoutCard3.setImageResource(resourceDraw3)
            layoutCard3.contentDescription = tarotShuffleThree.toString()
            textThreeTrue = true
            if (textOneTrue && textTwoTrue && textFourthTrue && textFifthTrue && textSixthTrue && textSeventhTrue) {
                afterClick()
            }
        }

        layoutCard4.setOnClickListener {
            layoutCard4.setImageResource(resourceDraw4)
            layoutCard4.contentDescription = tarotShuffleFourth.toString()
            textFourthTrue = true
            if (textOneTrue && textTwoTrue && textThreeTrue && textFifthTrue && textSixthTrue && textSeventhTrue) {
                afterClick()
            }
        }

        layoutCard5.setOnClickListener {
            layoutCard5.setImageResource(resourceDraw5)
            layoutCard5.contentDescription = tarotShuffleFifth.toString()
            textFifthTrue = true
            if (textOneTrue && textTwoTrue && textThreeTrue && textFourthTrue && textSixthTrue && textSeventhTrue) {
                afterClick()
            }
        }

        layoutCard6.setOnClickListener {
            layoutCard6.setImageResource(resourceDraw6)
            layoutCard6.contentDescription = tarotShuffleSixth.toString()
            textSixthTrue = true
            if (textOneTrue && textTwoTrue && textThreeTrue && textFourthTrue && textFifthTrue && textSeventhTrue) {
                afterClick()
            }
        }

        layoutCard7.setOnClickListener {
            layoutCard7.setImageResource(resourceDraw7)
            layoutCard7.contentDescription = tarotShuffleSeventh.toString()
            textSeventhTrue = true
            if (textOneTrue && textTwoTrue && textThreeTrue && textFourthTrue && textFifthTrue && textSixthTrue) {
                afterClick()
            }
        }
    }
}

