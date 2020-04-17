package bma.amine.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    private val smartphone1 = Smartphone(
        "Samsung",
        "Silver",
        "G980",
        "Galaxy S20 Ultra",
        150000L,
        101,
        R.drawable.galaxy_s20,
        "Le Samsung Galaxy S20 est un smartphone haut de gamme de Samsung annoncé en " +
                "février 2020 et disponible début mars 2020 qui succède au Galaxy S10. Il est " +
                "équipé d'un écran AMOLED de 6,2 pouces certifié HDR10+, d'un triple capteur photo " +
                "polyvalent entre ultra grand-angle et zoom 3X (30X en hybride) et d'un processeur " +
                "Exynos 990 gravé en 7 nm épaulé par 8 Go de RAM (12 Go en version 5G). Il est " +
                "disponible en version 4G ou 4G+5G et avec 128 Go de stockage UFS 3.0.")

    private val smartphone2 = Smartphone(
        "Apple",
        "Noir",
        "AX11000",
        "iPhone 11",
        180000L,
        98,
        R.drawable.iphone_11_black,
        "L'iPhone 11 est le modèle le plus accessible de la douzième génération du " +
                "célèbre smartphone d'Apple. Successeur direct de l'iPhone XR, il dispose d'un " +
                "écran LCD de 6,1 pouces, un SoC Apple A13 Bionic et un double capteur photo" +
                " arrière.")

    private val smartphone3 = Smartphone(
        "Apple",
        "Vert",
        "AX11001",
        "iPhone 11 Pro",
        200000L,
        110,
        R.drawable.iphone_11_pro_max,
        "L'iPhone 11 Pro Max est la version grand format de l'iPhone 11 Pro. Successeur" +
                " direct de l'iPhone XS Max, il dispose d'un écran OLED de 6,5 pouces, un SoC" +
                " Apple A13 Bionic et un triple capteur photo arrière.")

    private val smartphone4 = Smartphone(
        "One Plus",
        "Bleu",
        "OP5101",
        "7T",
        130000L,
        71,
        R.drawable.oneplus_7t,
        "Le OnePlus 7T est le successeur du OnePlus 7. Evolution de ce dernier, il est" +
                " équipé d'un SoC Qualcomm Snapdragon 855+ et une nouvelle solution pour la photo" +
                " avec un triple capteur arrière de 48+12+16 mégapixels.")

    private val smartphone5 = Smartphone(
        "Huawei",
        "Bleu",
        "HM520",
        "Mate 30 Pro",
        110000L,
        69,
        R.drawable.huawei_mate30_pro,
        "Le Huawei Mate 30 Pro est un smartphone haut de gamme annoncé le 19 septembre" +
                " 2019. Il est le premier smartphone à être équipé d'un SoC Kirin 990, il embarque" +
                " un écran AMOLED de 6,53 pouces et un triple capteur arrière de 40+8+40" +
                " mégapixels.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.num))
        recyclerView.adapter = ProductAdapter(this,loadData())
    }



    fun loadData():List<OrderLine> {
        val data = mutableListOf<OrderLine>()

        data.add(OrderLine(smartphone1,0))
        data.add(OrderLine(smartphone2,0))
        data.add(OrderLine(smartphone3,0))
        data.add(OrderLine(smartphone4,0))
        data.add(OrderLine(smartphone5,0))
        return data
    }

}
