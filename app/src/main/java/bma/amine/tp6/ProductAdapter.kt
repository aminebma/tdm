package bma.amine.tp6

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var context:Context, var data:List<OrderLine>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false))
    }

    override fun getItemCount() = data.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = data[position].product
        holder.productImage.setImageResource(product.image)
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

        holder.itemView.setOnClickListener {
            val product = data[position].product
            if(isTwoPane()){
                val activity = context as Activity

                val productImage = activity.findViewById(R.id.pImage) as ImageView
                val productType = activity.findViewById(R.id.pType) as TextView
                val productName = activity.findViewById(R.id.pName) as TextView
                val quantity = activity.findViewById(R.id.qte) as TextView
                val description = activity.findViewById(R.id.description) as TextView
                val price = activity.findViewById(R.id.prix) as TextView
                val brand = activity.findViewById(R.id.brand) as TextView
                val model = activity.findViewById(R.id.model) as TextView
                val color = activity.findViewById(R.id.color) as TextView

                productImage.setImageResource(product.image)
                productName.text = product.name
                description.text = product.description
                quantity.text = product.Qte.toString()
                price.text = product.price.toString()
                when(product){
                    is Smartphone -> {
                        productType.text = "Smartphone"
                        brand.text = product.brand
                        model.text = product.model
                        color.text = product.color
                    }
                }
            }
            else{
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("product", product)
                context.startActivity(intent)
            }

        }
    }

    private fun isTwoPane():Boolean{
        val activity = context as Activity
        return activity.findViewById<View>(R.id.detailsFragment)!=null
    }

}

class ProductViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val productInfos = view.findViewById(R.id.productInfo) as TextView
    val price = view.findViewById(R.id.price) as TextView
    val productImage = view.findViewById(R.id.productImg) as ImageView
    val quantity = view.findViewById(R.id.quantity) as TextView
    val min = view.findViewById(R.id.minBtn) as ImageButton
    val add = view.findViewById(R.id.addBtn) as ImageButton
}