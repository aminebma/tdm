package bma.amine.tp6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    private val smartphone1 = Smartphone("Samsung","Blanc","G980","Galaxy S20",150000L,10)
    private val smartphone2 = Smartphone("Apple","Noir","AX11000","iPhone 11",180000L,7)
    private val smartphone3 = Smartphone("Apple","Rouge","AX11001","iPhone 11S",200000L,7)
    private val smartphone4 = Smartphone("One Plus","Bleu","OP5101","8T",130000L,7)
    private val smartphone5 = Smartphone("Huawei","Gold","H99","Mate 30",110000L,7)
    private val pack1:Pack=Pack(
        "Gift Name 1",
        5,
        "Pack de rentrée",
        500000,
        5
    )
    private val pack2:Pack=Pack(
        "Gift Name 2",
        5,
        "Pack de fin d\'année",
        300000,
        5
    )
    private val pack3:Pack=Pack(
        "Gift Name 3",
        5,
        "Pack de printemps",
        700000,
        5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(this,loadData())
        val nav = findNavController(R.id.nav_fragment)
        NavigationUI.setupActionBarWithNavController(this,nav)
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
        val navController = findNavController(R.id.nav_fragment)
        return navController.navigateUp()
    }

    fun loadData():List<OrderLine> {
        val data = mutableListOf<OrderLine>()

        pack1.addSmartphone(smartphone1,2)
        pack1.addSmartphone(smartphone2,3)
        pack2.addSmartphone(smartphone2,2)
        pack3.addSmartphone(smartphone3,2)
        pack3.addSmartphone(smartphone5,3)
        data.add(OrderLine(smartphone1))
        data.add(OrderLine(pack1))
        data.add(OrderLine(smartphone2))
        data.add(OrderLine(pack2))
        data.add(OrderLine(pack3))
        data.add(OrderLine(smartphone3))
        data.add(OrderLine(smartphone4))
        data.add(OrderLine(smartphone5))
        return data
    }
}
