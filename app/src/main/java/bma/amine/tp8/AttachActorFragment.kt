package bma.amine.tp8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_attach_actor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AttachActorFragment : Fragment() {

    var _selectedActors:MutableList<Double> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attach_actor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
        actorsList.layoutManager = LinearLayoutManager(requireActivity())
        movieTitle.text = arguments?.getString("title")
        movieYear.text = "Année: ${arguments?.getString("year")}"
        movieLanguage.text = "Langue: ${arguments?.getString("language")}"

        validateActorsBtn.setOnClickListener {
            for(actorId in _selectedActors){
                val call = RetrofitService.endpoint.addMovieActor(
                    MovieActor(
                        arguments?.getDouble("id"),
                        actorId
                    )
                )
                call.enqueue(object : Callback<Double> {
                    override fun onFailure(call: Call<Double>, t: Throwable) {
                        Toast.makeText(activity!!, "Une erreur s'est produite", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Double>, response: Response<Double>) {
                        if (response.isSuccessful) {
                            Toast.makeText(activity!!, "Acteur attaché avec succès !", Toast.LENGTH_SHORT)
                        } else {
                            Toast.makeText(activity!!, "Une erreur s'est produite", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                })
            }
            requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_attachActorFragment_to_home)
        }
    }

    fun loadData(){
        val call = RetrofitService.endpoint.getAllActors()
        call.enqueue(object: Callback<List<Actor>>{
            override fun onFailure(call: Call<List<Actor>>, t: Throwable) {
                Toast.makeText(activity!!,"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Actor>>, response: Response<List<Actor>>) {
                if(response.isSuccessful){
                    val list = response.body()
                    actorsList.adapter = ActorAdapter(requireActivity(),this@AttachActorFragment, list!!)
                }else{
                    Toast.makeText(activity!!,"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
