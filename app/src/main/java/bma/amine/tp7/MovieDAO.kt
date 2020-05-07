package bma.amine.tp7

import androidx.room.*

@Dao
interface MovieDAO {
    @Insert
    fun addMovie(movie:Movie)

    @Query("SELECT * FROM Movies")
    fun getAllMovies():List<Movie>

    @Query("SELECT * FROM Movies WHERE title=:movieName")
    fun getMoviesByName(movieName: String):List<Movie>

    @Update
    fun updateMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

}