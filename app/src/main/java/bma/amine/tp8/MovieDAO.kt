package bma.amine.tp8

import androidx.room.*

@Dao
interface MovieDAO {
    @Insert
    fun addMovie(movie:Movie)

    @Query("SELECT * FROM Movies")
    fun getAllMovies():List<Movie>

    @Query("SELECT * FROM Movies WHERE title=:movieName")
    fun getMoviesByName(movieName: String):List<Movie>

}