package bma.amine.tp7

import android.app.Application

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        RoomService.context = applicationContext
    }
}