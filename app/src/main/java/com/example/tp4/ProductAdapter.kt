package com.example.tp4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var context:Context, var data:List<OrderLine>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        when(val product = data[position].product){
            is Pack ->{
                holder.productInfos.text = product.name
                holder.price.text = product.price.toString()
                holder.productImage.setImageResource(R.drawable.ic_pack)
                holder.quantity.text = data[position].qteOrder.toString()
            }
            is Smartphone ->{
                holder.productInfos.text = product.brand + " " + product.name + " " +product.model + " " + product.color
                holder.price.text = product.price.toString()
                holder.productImage.setImageResource(R.drawable.ic_phone)
                holder.quantity.text = data[position].qteOrder.toString()
            }
        }

        holder.add.setOnClickListener{
            if(data[position].qteOrder<data[position].product.Qte) {
                data[position].qteOrder++
            }
            notifyDataSetChanged()
        }

        holder.min.setOnClickListener{
            if(data[position].qteOrder>0){
                data[position].qteOrder--
            }
            notifyDataSetChanged()
        }
    }

}

class ProductViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val productInfos = view.findViewById<TextView>(R.id.productInfo) as TextView
    val price = view.findViewById<TextView>(R.id.price) as TextView
    val productImage = view.findViewById<ImageView>(R.id.productImage) as ImageView
    val quantity = view.findViewById<TextView>(R.id.quantity) as TextView
    val min = view.findViewById<ImageButton>(R.id.minBtn) as ImageButton
    val add = view.findViewById<ImageButton>(R.id.addBtn) as ImageButton
}