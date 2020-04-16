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
        "Blanc",
        "G980",
        "Galaxy S20 Ultra",
        150000L,
        10,
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
        7,
        R.drawable.galaxy_s20,
        "Le Samsung Galaxy S20 est un smartphone haut de gamme de Samsung annoncé en" +
                " février 2020 et disponible début mars 2020 qui succède au Galaxy S10. Il est " +
                "équipé d'un écran AMOLED de 6,2 pouces certifié HDR10+, d'un triple capteur photo" +
                " polyvalent entre ultra grand-angle et zoom 3X (30X en hybride) et d'un processeur" +
                " Exynos 990 gravé en 7 nm épaulé par 8 Go de RAM (12 Go en version 5G). Il est " +
                "disponible en version 4G ou 4G+5G et avec 128 Go de stockage UFS 3.0.")

    private val smartphone3 = Smartphone(
        "Apple",
        "Rouge",
        "AX11001",
        "iPhone 11S",
        200000L,
        7,
        R.drawable.galaxy_s20,
        "Le Samsung Galaxy S20 est un smartphone haut de gamme de Samsung annoncé en" +
                " février 2020 et disponible début mars 2020 qui succède au Galaxy S10. Il est " +
                "équipé d'un écran AMOLED de 6,2 pouces certifié HDR10+, d'un triple capteur " +
                "photo polyvalent entre ultra grand-angle et zoom 3X (30X en hybride) et d'un " +
                "processeur Exynos 990 gravé en 7 nm épaulé par 8 Go de RAM (12 Go en version 5G). " +
                "Il est disponible en version 4G ou 4G+5G et avec 128 Go de stockage UFS 3.0.")

    private val smartphone4 = Smartphone(
        "One Plus",
        "Bleu",
        "OP5101",
        "8T",
        130000L,
        7,
        R.drawable.galaxy_s20,
        "Le Samsung Galaxy S20 est un smartphone haut de gamme de Samsung annoncé en " +
                "février 2020 et disponible début mars 2020 qui succède au Galaxy S10. Il est " +
                "équipé d'un écran AMOLED de 6,2 pouces certifié HDR10+, d'un triple capteur photo" +
                " polyvalent entre ultra grand-angle et zoom 3X (30X en hybride) et d'un processeur" +
                " Exynos 990 gravé en 7 nm épaulé par 8 Go de RAM (12 Go en version 5G). Il est" +
                " disponible en version 4G ou 4G+5G et avec 128 Go de stockage UFS 3.0.")

    private val smartphone5 = Smartphone(
        "Huawei",
        "Gold",
        "H99",
        "Mate 30",
        110000L,
        7,
        R.drawable.galaxy_s20,
        "Le Samsung Galaxy S20 est un smartphone haut de gamme de Samsung annoncé en " +
                "février 2020 et disponible début mars 2020 qui succède au Galaxy S10. Il est " +
                "équipé d'un écran AMOLED de 6,2 pouces certifié HDR10+, d'un triple capteur photo " +
                "polyvalent entre ultra grand-angle et zoom 3X (30X en hybride) et d'un processeur " +
                "Exynos 990 gravé en 7 nm épaulé par 8 Go de RAM (12 Go en version 5G). Il est " +
                "disponible en version 4G ou 4G+5G et avec 128 Go de stockage UFS 3.0.")

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
