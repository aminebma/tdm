package com.example.tp3

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.solver.widgets.Guideline
import androidx.recyclerview.widget.RecyclerView

class ProductViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val productContainer = view.findViewById<ImageView>(R.id.container) as ImageView
    val productInfos = view.findViewById<TextView>(R.id.productInfo) as TextView
    val price = view.findViewById<TextView>(R.id.price) as TextView
    val productImage = view.findViewById<ImageView>(R.id.productImage) as ImageView
    val quantity = view.findViewById<TextView>(R.id.quantity) as TextView
    val min = view.findViewById<ImageButton>(R.id.minBtn) as ImageButton
    val add = view.findViewById<ImageButton>(R.id.addBtn) as ImageButton
}