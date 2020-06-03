package bma.amine.tp8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ActorDAO {
    @Insert
    fun addTmpActor(actor: ActorTmp): Long

    @Query("DELETE FROM Actors WHERE id = :tmpActorId")
    fun deleteTmpActor(tmpActorId: Long)
}