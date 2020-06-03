package bma.amine.tp8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.work.*
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
            val tmpActorId:Long = RoomService.appDatabase.getActorDao().addTmpActor(
            ActorTmp(
                firstNameT.text.toString(),
                lastNameT.text.toString(),
                gender))
            val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.UNMETERED)
                .build()
            val data = Data.Builder()
            data.putLong("tmpActorId", tmpActorId)
            data.putString("firstName", firstNameT.text.toString())
            data.putString("lastName", lastNameT.text.toString())
            data.putString("gender", gender)
            val req = OneTimeWorkRequest.Builder(ActorWorker::class.java)
                .setConstraints(constraints)
                .setInputData(data.build())
                .build()
            val workManager = WorkManager.getInstance(requireActivity())
            workManager.enqueueUniqueWork("Adding Actor", ExistingWorkPolicy.REPLACE, req)
            requireActivity().findNavController(R.id.nav_frag).navigate(R.id.action_addActorFragment_to_home)
        }
    }
}
