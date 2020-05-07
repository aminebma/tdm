package bma.amine.tp7

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    lateinit var mDatabase: AppDatabase

    @Before
    fun initDB(){
        mDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDatabase::class.java).build()
    }

    @Test
    fun testInsertAndGetMovie(){
        val movie1 = Movie(1,"Snowden","2016","EN",1)
        mDatabase?.getMovieDao().addMovie(movie1)
        var list = mDatabase?.getMovieDao().getAllMovies()
        Assert.assertEquals(movie1,list.get(0))
    }

    @After
    fun closeDB(){
        mDatabase?.close()
    }



}
