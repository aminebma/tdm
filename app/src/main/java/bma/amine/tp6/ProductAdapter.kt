package bma.amine.tp6

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ProductAdapter(var context:Context, var data:List<OrderLine>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false))
    }

    override fun getItemCount() = data.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = data[position].product
        when(product){
            is Pack ->{
                holder.productInfos.text = product.name
                holder.price.text = product.price.toString()
                holder.quantity.text = data[position].qteOrder.toString()
            }
            is Smartphone ->{
                holder.productInfos.text = product.brand + " " + product.name + " " +product.model + " " + product.color
                holder.price.text = product.price.toString()
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

        holder.itemView.setOnClickListener {view->
            val ordersList = mutableListOf<OrderLine>()
            var totalAmount:Long = 0

            for(item in data) {
                if (item.qteOrder > 0) {
                    ordersList.add(item)
                    totalAmount+=item.product.price*item.qteOrder
                }
            }

            val order = Order(1, Date(), ordersList, totalAmount)

            var bundle = bundleOf("orderAmount" to order.amount)

            view.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)

        }
    }

}

class ProductViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val productInfos = view.findViewById(R.id.productInfo) as TextView
    val price = view.findViewById(R.id.price) as TextView
    val quantity = view.findViewById(R.id.quantity) as TextView
    val min = view.findViewById(R.id.minBtn) as ImageButton
    val add = view.findViewById(R.id.addBtn) as ImageButton
}