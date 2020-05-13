package bma.amine.tp8

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_add_actor.*

class AddActorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_actor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        validateActor.setOnClickListener {
            val gender = if(sexSwith.isChecked) "Homme" else "Femme"
            var actor = Actor(firstNameT.text.toString(),lastNameT.text.toString(),gender)
            try {
                RoomService.appDatabase.getActorDao().addActor(actor)
                val pref = requireActivity().getSharedPreferences("appData", Context.MODE_PRIVATE)
                pref.edit().putBoolean("isActorAvailable", true).apply()
                Toast.makeText(requireActivity(),"Acteur ajouté avec succès !", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                println(e.message)
                Toast.makeText(requireActivity(),"L'ajout de l'acteur a échoué.", Toast.LENGTH_SHORT).show()
            }
            finally {
                requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_addActorFragment_to_home)
            }
        }
    }
}
