package bma.amine.tp5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import bma.amine.tp5.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_details.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getSerializableExtra("product") as Product
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
}
