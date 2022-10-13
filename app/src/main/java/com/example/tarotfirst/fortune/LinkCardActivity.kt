package com.example.tarotfirst.fortune

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotfirst.R


class LinkCardActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singlecard) // as in CardOfTheDayActivity

        // update number of Tarot from another activity
        val numberTarot = intent.getStringExtra("Data")

        // set card number from intent from another activity
        val cardNumber = "tarot_${numberTarot.toString()}"

        // set number of Tarot on text
        val resultCardView: TextView = findViewById(R.id.cardName)
        val resourceCard = resources.getIdentifier(
            cardNumber,
            "string",
            "com.example.tarotfirst"
        )

        // set identifier to card's name
        resultCardView.setText(resourceCard)

        // set number of identifier to selected card
        val resultImageView: ImageView = findViewById(R.id.imageView)
        val resourceDraw = resources.getIdentifier(
            cardNumber,
            "drawable",
            "com.example.tarotfirst"
        )

        // set identifier to imageCard
        resultImageView.setImageResource(resourceDraw)
        resultImageView.contentDescription = numberTarot.toString()

        // set number of identifier to selected card description
        val resultTextView: TextView = findViewById(R.id.cardDesc)
        val resourceText = resources.getIdentifier(
            "tarotDescribing_$numberTarot",
            "string",
            "com.example.tarotfirst"
        )

        // set identifier to description of cards
        resultTextView.setText(resourceText)
        resultTextView.movementMethod = ScrollingMovementMethod()

        // animation of Tarot
        /*** val anim = AnimationUtils.loadAnimation(this, R.anim.anim)

        resultImageView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        resultImageView.startAnimation(anim)
                    }
                }

                return v?.onTouchEvent(event) ?: true
            }
        }) ***/

    }
}