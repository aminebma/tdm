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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav = findNavController(R.id.nav_fragment)
        NavigationUI.setupActionBarWithNavController(this,nav)
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
        val navController = findNavController(R.id.nav_fragment)
        return navController.navigateUp()
    }
}
