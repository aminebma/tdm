package bma.amine.tp8

import android.app.Application

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        RoomService.context = applicationContext
    }
}