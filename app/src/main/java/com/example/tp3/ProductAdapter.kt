package com.example.tp3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var context:Context, var data:List<Product>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        when(val product = data[position]){
            is Pack ->{
                holder.productInfos.text = product.name
                holder.price.text = product.price.toString()
                holder.productImage.setImageResource(R.drawable.ic_pack)
            }
            is Smartphone ->{
                holder.productInfos.text = product.brand + " " + product.name + " " +product.model + " " + product.color
                holder.price.text = product.price.toString()
                holder.productImage.setImageResource(R.drawable.ic_phone)
            }
        }
        holder.add.setOnClickListener{
            var qte =Integer.parseInt(holder.quantity.text.toString())
            if(qte<data[position].Qte) {
                qte++
                holder.quantity.text = qte.toString()
            }
            notifyDataSetChanged()
        }

        holder.min.setOnClickListener{
            var qte =Integer.parseInt(holder.quantity.text.toString())
            if(qte>0) {
                qte--
                holder.quantity.text = qte.toString()
            }
            notifyDataSetChanged()
        }
    }

}