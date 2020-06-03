package bma.amine.tp8

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ActorTmp::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getActorDao():ActorDAO
}