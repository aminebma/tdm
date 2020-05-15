package bma.amine.tp8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_attach_actor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ActorAdapter(var context: Context, var fragment:AttachActorFragment ,var data:List<Actor>): RecyclerView.Adapter<ActorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(context).inflate(R.layout.element_layout, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.image.setImageResource(R.drawable.ic_actor)
        holder.lastName.text = "Nom: ${data[position].lastName}"
        holder.firstName.text = "Prénom: ${data[position].firstName}"
        holder.gender.text = "Sexe: ${data[position].gender}"

        holder.itemView.setOnClickListener {
            if(!fragment._selectedActors.contains(data[position].id))
                fragment._selectedActors.add(data[position].id!!)
            else
                Toast.makeText(context,"Acteur déjà selectionné !", Toast.LENGTH_SHORT).show()
        }
    }
}

class ActorViewHolder(view: View):RecyclerView.ViewHolder(view) {
   val firstName = view.findViewById(R.id.firstField) as TextView
   val lastName = view.findViewById(R.id.secondField) as TextView
   val gender = view.findViewById(R.id.thirdField) as TextView
   val image = view.findViewById(R.id.elementIcon) as ImageView
}