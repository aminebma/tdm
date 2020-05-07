package bma.amine.tp7

import androidx.room.*

@Dao
interface ActorDAO {

    @Insert
    fun addActor(actor: Actor)

    @Query("SELECT * FROM Actors")
    fun getAllActors():List<Actor>

    @Update
    fun updateActor(actor: Actor)

    @Delete
    fun deleteActor(actor: Actor)

}