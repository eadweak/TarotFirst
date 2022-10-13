package com.example.tarotfirst.lists

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.tarotfirst.R
import com.example.tarotfirst.cardClasses.Card

// mutable adapter of List<Card>
class MyListAdapter (var ctx: Context, var resource: Int, var items: List<Card>)
    :ArrayAdapter<Card>(ctx, resource, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(ctx)

        // define adapter on activity
        val view: View = layoutInflater.inflate(resource, null)

        // set resources on Views
        val imageView: ImageView = view.findViewById(R.id.iconCard)
        val cardsTitle: TextView = view.findViewById(R.id.title)
        val cardsContent: TextView = view.findViewById(R.id.content)

        // define card's position
        val mItems: Card = items[position]

        // set drawable and string values to adapter
        imageView.setImageDrawable(ctx.resources.getDrawable(mItems.photo))
        cardsTitle.text = mItems.title
        cardsContent.text = mItems.desc

        return view
    }

}