package bma.amine.tp8

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
        moviesList.layoutManager = LinearLayoutManager(requireActivity())

        addActor.setOnClickListener {
            requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_home_to_addActorFragment)
        }

        addMovie.setOnClickListener {
            requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_home_to_addMovieFragment)
        }

        searchButton.setOnClickListener {
            val call = RetrofitService.endpoint.getMovieActorsByTitle(searchBar.text.toString())
            call.enqueue(object : Callback<List<Actor>> {

                override fun onFailure(call: Call<List<Actor>>, t: Throwable) {
                    Toast.makeText(context, "Une erreur s'est produite", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<List<Actor>>, response: Response<List<Actor>>) {
                    if (response.isSuccessful) {
                        val list = response.body()
                        for (item in list!!)
                            Toast.makeText(
                                context,
                                "${item.firstName} ${item.lastName}",
                                Toast.LENGTH_SHORT
                            ).show()
                    } else {
                        Toast.makeText(context, "Une erreur s'est produite", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
        }
    }

    fun loadData(){
        val call = RetrofitService.endpoint.getAllMovies()
        call.enqueue(object: Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(activity!!,"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if(response.isSuccessful){
                    val list = response.body()
                    moviesList.adapter = MovieAdapter(requireActivity(), list!!)
                }else{
                    Toast.makeText(activity!!,"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
