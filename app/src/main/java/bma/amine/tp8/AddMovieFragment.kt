package bma.amine.tp8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_add_movie.*

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
            val bundle = bundleOf(
                "title" to titleT.text.toString(),
                "year" to yearT.text.toString(),
                "language" to languageT.text.toString()
            )
            requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_addMovieFragment_to_attachActorFragment,bundle)
        }
    }
}
