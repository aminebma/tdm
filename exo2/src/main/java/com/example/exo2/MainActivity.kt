package com.example.exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val productList:MutableList<Product> = mutableListOf()
    val smartphone1 = Smartphone("Samsung","Blanc","G980","Galaxy S20",150000L,10)
    val smartphone2 = Smartphone("Apple","Noir","AX11000","iPhone 11",180000L,7)
    val pack1:Pack=Pack(
        "Gift Name 1",
        5,
        "Pack de rentrée",
        500000,
        5
    )
    val pack2:Pack=Pack(
        "Gift Name 2",
        5,
        "Pack de fin d\'année",
        300000,
        5
    )
    var qte = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pack1.addSmartphone(smartphone1,2)
        pack1.addSmartphone(smartphone2,3)
        pack2.addSmartphone(smartphone2,2)

        productList.add(smartphone1)
        productList.add(pack1)
        productList.add(smartphone2)
        productList.add(pack2)

        displayProduct(smartphone1)

        addBtn.setOnClickListener{
            addProduct(smartphone1)
        }

        minBtn.setOnClickListener{
            minProduct(smartphone1)
        }
    }

    fun displayProduct(product: Product){
        when(product){
            is Smartphone->{
                productImage.setImageResource(R.drawable.ic_phone)
                productInfo.text = product.brand + " " + product.name + " " +product.model + " " + product.color
            }
            is Pack->{
                productImage.setImageResource(R.drawable.ic_pack)
                productInfo.text = product.name
            }
        }
        price.text= NumberFormat.getInstance(Locale.FRANCE).format(product.price).toString() + " DA"
    }

    fun addProduct(product: Product){
        if(qte<10) {
            qte++
            quantity.text = qte.toString()
        }

    }

    fun minProduct(product: Product){
        if(qte>0) {
            qte--
            quantity.text = qte.toString()
        }
    }

}
