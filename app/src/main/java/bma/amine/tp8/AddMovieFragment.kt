package bma.amine.tp8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_add_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class AddMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        validateMovieBtn.setOnClickListener {
            val call = RetrofitService.endpoint.addMovie(
                Movie(
                    null,
                    titleT.text.toString(),
                    yearT.text.toString(),
                    languageT.text.toString()))
            call.enqueue(object: Callback<Double> {
                override fun onFailure(call: Call<Double>, t: Throwable) {
                    Toast.makeText(activity!!,"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Double>, response: Response<Double>) {
                    if(response.isSuccessful){
                        Toast.makeText(activity!!,"Film ajouté avec succès !",Toast.LENGTH_SHORT)
                        val bundle = bundleOf(
                            "id" to response.body(),
                            "title" to titleT.text.toString(),
                            "year" to yearT.text.toString(),
                            "language" to languageT.text.toString()
                        )
                        requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_addMovieFragment_to_attachActorFragment,bundle)
                    }else{
                        Toast.makeText(activity!!,"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}
