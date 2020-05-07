package bma.amine.tp7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_attach_actor.*

class AttachActorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attach_actor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        actorsList.layoutManager = LinearLayoutManager(requireActivity())
        actorsList.adapter = ActorAdapter(requireActivity(),this, loadData())
        movieTitle.text = arguments?.getString("title")
        movieYear.text = "Année: ${arguments?.getString("year")}"
        movieLanguage.text = "Langue: ${arguments?.getString("language")}"
    }

    fun loadData():List<Actor>{
        return RoomService.appDatabase.getActorDao().getAllActors()
    }
}
