package idnull.z.myquotes.data

import android.app.Application
import idnull.z.myquotes.data.DI.DaggerAppComponent

class App: Application() {


    val component by lazy {
        DaggerAppComponent.builder().context(this ).build()
    }


}