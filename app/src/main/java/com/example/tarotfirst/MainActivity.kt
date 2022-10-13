package com.example.tarotfirst

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotfirst.R.id
import com.example.tarotfirst.fortune.CardOfTheDayActivity
import com.example.tarotfirst.lists.ListOfCardsActivity
import com.example.tarotfirst.lists.ReadingCardsActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Animation from main text
        var anim = AnimationUtils.loadAnimation(this, R.anim.slide_to_left)
        var mainText: TextView = findViewById(id.mainText)
        mainText.startAnimation(anim)
        mainText.clearAnimation()

        // Going into Card's of Day
        val intentCardOfTheDay = Intent(this, CardOfTheDayActivity::class.java)
        val button1: Button = findViewById(id.button1)
        button1.setOnClickListener {
            startActivity(intentCardOfTheDay)
        }

        // Going into List of Cards
        val intentListOfCards = Intent(this, ListOfCardsActivity::class.java)
        val button2: Button = findViewById(id.button2)
        button2.setOnClickListener {
            startActivity(intentListOfCards)
        }

        // Going into Layouts of Cards
        val intentReadingCards = Intent(this, ReadingCardsActivity::class.java)
        val button3: Button = findViewById(id.button3)
        button3.setOnClickListener {
            startActivity(intentReadingCards)
        }
    }
}
