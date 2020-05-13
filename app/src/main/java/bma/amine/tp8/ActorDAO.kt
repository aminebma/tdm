package bma.amine.tp8

import androidx.room.*

@Dao
interface ActorDAO {

    @Insert
    fun addActor(actor: Actor)

    @Query("SELECT * FROM Actors")
    fun getAllActors():List<Actor>

}