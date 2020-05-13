package bma.amine.tp8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_attach_actor.*
import java.lang.Exception

class ActorAdapter(var context: Context, var fragment:AttachActorFragment ,var data:List<Actor>): RecyclerView.Adapter<ActorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(context).inflate(R.layout.actor_layout, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.lastName.text = "Nom: ${data[position].lastName}"
        holder.firstName.text = "Prénom: ${data[position].firstName}"
        holder.gender.text = "Sexe: ${data[position].gender}"

        holder.itemView.setOnClickListener {view ->
            val movie = Movie(
                fragment.movieTitle.text.toString(),
                fragment.movieYear.text.toString(),
                fragment.movieYear.text.toString(),
                data[position].id
                )
            try{
                RoomService.appDatabase.getMovieDao().addMovie(movie)
                Toast.makeText(context,"Film ajouté avec succès !", Toast.LENGTH_SHORT).show()
            }catch (e: Exception){
                println(e.message)
                Toast.makeText(context,"L'ajout du film a échoué.", Toast.LENGTH_SHORT).show()
            }
            finally {
                view.findNavController().navigate(R.id.action_attachActorFragment_to_home)
            }
        }
    }
}


class ActorViewHolder(view: View):RecyclerView.ViewHolder(view) {
   val firstName = view.findViewById(R.id.actorLastName) as TextView
   val lastName = view.findViewById(R.id.actorFirstName) as TextView
   val gender = view.findViewById(R.id.actorSex) as TextView
}