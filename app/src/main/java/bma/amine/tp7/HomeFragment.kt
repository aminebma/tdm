package bma.amine.tp7

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var pref:SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pref = requireActivity().getSharedPreferences("appData", Context.MODE_PRIVATE)
        if(pref.getBoolean("isActorAvailable", false)){
            addMovie.isClickable = true
            addMovie.isEnabled = true
        }
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addActor.setOnClickListener {
            requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_home_to_addActorFragment)
        }

        addMovie.setOnClickListener {
            if(pref.getBoolean("isActorAvailable", false))
                requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_home_to_addMovieFragment)
            else
                Toast.makeText(requireActivity(),"Veuillez insérer au moins un acteur.", Toast.LENGTH_SHORT).show()
        }
    }
}
