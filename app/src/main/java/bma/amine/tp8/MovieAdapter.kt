package bma.amine.tp8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieAdapter(var context: Context, var data:List<Movie>): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.element_layout, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.image.setImageResource(R.drawable.ic_film)
        holder.title.text = "Titre: ${data[position].title}"
        holder.year.text = "Année: ${data[position].year}"
        holder.itemView.setOnClickListener {
            val call = RetrofitService.endpoint.getMovieActorsByTitle(data[position].title)
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
}

class MovieViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val title = view.findViewById(R.id.firstField) as TextView
    val year = view.findViewById(R.id.secondField) as TextView
    val image = view.findViewById(R.id.elementIcon) as ImageView
}