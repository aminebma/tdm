package bma.amine.tp7

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Actors")
data class Actor(
    @PrimaryKey
    val id:Long,
    val firstName: String,
    val lastName: String,
    val gender: String
)