package bma.amine.tp7

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Movies",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Actor::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("idActor"),
            onDelete = ForeignKey.CASCADE
        )
    )
)

data class Movie (
    @PrimaryKey
    val id:Long,
    val title:String,
    val year:String,
    val language:String,
    val idActor:Long?
)