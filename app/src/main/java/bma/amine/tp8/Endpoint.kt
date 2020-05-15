package bma.amine.tp8

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoint {

    @GET("/movie/getmovies")
    fun getAllMovies(): Call<List<Movie>>

    @GET("movie/getmovie/{title}")
    fun getMovieByTitle(@Path("title") title: String): Call<Movie>

    @GET("/actor/getactors")
    fun getAllActors(): Call<List<Actor>>

    @GET("/movie/getmoviesactors")
    fun getMovieActors(): Call<List<MovieActor>>

    @GET("/movie/getmovieactors/{title}")
    fun getMovieActorsByTitle(@Path("title") title: String): Call<List<Actor>>

    @POST("/movie/addmovie")
    fun addMovie(@Body movie: Movie): Call<Double>

    @POST("/actor/addactor")
    fun addActor(@Body actor: Actor): Call<Double>

    @POST("/movie/addmovieactor")
    fun addMovieActor(@Body movieActor: MovieActor): Call<Double>
}