package idnull.z.myquotes.data.DI

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import idnull.z.myquotes.presentation.quotes_main.MainFragment


@Component(modules = [MainModule::class])
interface AppComponent {


    @Component.Builder
    interface AppComponentBuilder{

        @BindsInstance
        fun context(context: Context):AppComponentBuilder


        fun build():AppComponent

    }


    fun inject(mainFragment: MainFragment)
}