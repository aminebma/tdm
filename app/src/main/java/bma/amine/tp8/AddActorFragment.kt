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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                val call = RetrofitService.endpoint.addActor(
                    Actor(
                        null,
                        firstNameT.text.toString(),
                        lastNameT.text.toString(),
                        gender))
                call.enqueue(object: Callback<Double> {
                    override fun onFailure(call: Call<Double>, t: Throwable) {
                        Toast.makeText(activity!!,"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Double>, response: Response<Double>) {
                        if(response.isSuccessful){
                            Toast.makeText(activity!!,"Acteur ajouté avec succès !",Toast.LENGTH_SHORT).show()
                            requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_addActorFragment_to_home)
                        }else{
                            Toast.makeText(activity!!,"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        }
    }
}
