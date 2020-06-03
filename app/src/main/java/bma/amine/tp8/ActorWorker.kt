package bma.amine.tp8

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.google.common.util.concurrent.ListenableFuture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActorWorker(val context: Context, val workParameters: WorkerParameters): ListenableWorker(context, workParameters){

    lateinit var future: SettableFuture<Result>
    val actor = Actor(null,inputData.getString("firstName")!!,inputData.getString("lastName")!!,inputData.getString("gender")!!)

    @SuppressLint("RestrictedApi")
    override fun startWork(): ListenableFuture<Result> {
        future = SettableFuture.create<Result>()
        addActor(actor)
        return future
    }

    private fun addActor(actor: Actor){
        val call = RetrofitService.endpoint.addActor(actor)
        call.enqueue(object: Callback<Double>{
            @SuppressLint("RestrictedApi")
            override fun onFailure(call: Call<Double>, t: Throwable) {
                Toast.makeText(context, "Une erreur s'est produite", Toast.LENGTH_SHORT)
                        .show()
                future.set(Result.retry())
            }

            @SuppressLint("RestrictedApi")
            override fun onResponse(call: Call<Double>, response: Response<Double>) {
                if(response.isSuccessful){
                    Toast.makeText(context, "Acteur ajouté avec succès !", Toast.LENGTH_SHORT)
                        .show()
                    RoomService.appDatabase.getActorDao().deleteTmpActor(inputData.getLong("tmpActorId",-1))
                    future.set(Result.success())
                }
                else{
                    Toast.makeText(context, "Une erreur s'est produite", Toast.LENGTH_SHORT)
                        .show()
                    future.set(Result.retry())
                }
            }
        })
    }
}

