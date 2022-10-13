package com.example.tarotfirst.cardClasses

import android.widget.TextView

class Tarot {
    fun shuffle(numSides: Int, secondSides: Int): Int {
        return (numSides..secondSides).random()
    }
}