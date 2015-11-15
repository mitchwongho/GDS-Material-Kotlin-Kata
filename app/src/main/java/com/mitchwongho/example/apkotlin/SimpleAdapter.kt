package com.mitchwongho.example.apkotlin

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import kotlinx.android.synthetic.simple_cardview.view.card_title

/**
 *
 */
class SimpleAdapter(val titles: Array<String>) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public val cardTitle: TextView = itemView.card_title
    }

    override fun getItemCount() = titles.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.cardTitle?.text = titles[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val card = LayoutInflater.from(parent?.context).inflate(R.layout.simple_cardview,
                parent, false)
        return ViewHolder(card)
    }
}