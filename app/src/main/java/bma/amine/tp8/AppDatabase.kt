package bma.amine.tp8

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Movie::class, Actor::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getMovieDao():MovieDAO
    abstract fun getActorDao():ActorDAO
}