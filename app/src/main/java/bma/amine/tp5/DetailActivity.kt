package bma.amine.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_details.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getSerializableExtra("product") as Product
        pImage.setImageResource(product.image)
        pName.text = product.name
        description.text = product.description
        qte.text = product.Qte.toString()
        prix.text = product.price.toString()
        when(product){
            is Smartphone -> {
                pType.text = "Smartphone"
                brand.text = product.brand
                model.text = product.model
                qte.text = product.color
            }
        }

    }
}
