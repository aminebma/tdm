package bma.amine.tp8

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Actors")
data class Actor(
    val firstName: String,
    val lastName: String,
    val gender: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}