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
data class Movie(
    val title:String,
    val year:String,
    val language:String,
    val idActor:Int?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}